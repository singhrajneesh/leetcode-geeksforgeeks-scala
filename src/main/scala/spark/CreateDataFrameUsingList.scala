package spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object CreateDataFrameUsingList extends App {
  System.setProperty("hadoop.home.dir", "/")
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sparkSession = SparkSession.builder().appName("local_test").master("local[*]")
    .getOrCreate()


  import sparkSession.implicits._

  val list = List(Seq(1, "one@gmail.com"),
    Seq(2, "two@gmail.com"),
    Seq(3, "three@gmail.com"),
    Seq(4, "four@gmail.com"))
  // Create RDD
  val rdd = sparkSession.sparkContext.parallelize(list)
  // Create DataFrame
  val df = rdd.map(row => (row.head.toString, row(1).toString )).toDF("rowId", "email")
  df.show()
}
