package spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object TwoFileReadProblem extends App {
  System.setProperty("hadoop.home.dir", "/")
  Logger.getLogger("org").setLevel(Level.ERROR)

  val sparkSession = SparkSession.builder().appName("local_test").master("local[*]")
    .getOrCreate()

  import sparkSession.implicits._

  import org.apache.spark.sql.functions._
  val first = sparkSession.read.option("header", "false").option("sep", " ").csv("src/main/resources/test1.txt")

   first.createOrReplaceTempView("first")

  val second = sparkSession.read.option("header", "false").option("sep", " ")
    .csv("src/main/resources/test2.txt")

  val union = first.union(second)

  val stringToIntConverter = udf((s:String) => s.convetStringToInt)

  val afterUdf = union.select(union.columns.map(column => stringToIntConverter(col(column)).as(column)):_*)


  def moveZerosToRight(row: Seq[Int]): Seq[Int] = {
    val zeros = row.filter(_ == 0)
    val nonZeros = row.filter(_ != 0)
    nonZeros ++ zeros
  }

  // UDF to apply the function to each row
  val moveZerosToRightUDF = udf((row: Seq[Int]) => moveZerosToRight(row))

  // Apply the UDF to each row in the DataFrame
  val movedDF = afterUdf.withColumn("moved_row", moveZerosToRightUDF(array(afterUdf.columns.map(col): _*)))

  movedDF.show(100, false)

  val numberOfColumns = afterUdf.columns.length
  val initialCarry = 0
  var carry = initialCarry
  val result = Array.fill(numberOfColumns)(0)
  for(i<- numberOfColumns-1 to 0 by -1)  {
    afterUdf.collect().foreach(row => {
      val (newSum, newCarry) = addWithCarry(row.getInt(i), result(i), carry)
      result(i) = newSum
      carry = newCarry
    })
  }

  afterUdf.show(100, false)
  println(carry + " " +result.mkString(" "))

  //TODO _* check the details about this important

//    sparkSession.sql("SELECT word FROM first LATERAL VIEW explode(split('word', ' ')) exploded_table AS word2")
//    .show(10)

  //second.show(10,false)


  def addWithCarry(x: Int, y:Int, carry:Int): (Int, Int)= {
    val number = x+y+carry
    (number%10,number/10)
  }

  implicit class convertStringToInt(x: String){
    def convetStringToInt:Int = {
      try {
        Integer.parseInt(x)
      } catch {
        case _: Throwable =>  0
      }
    }
  }

}
