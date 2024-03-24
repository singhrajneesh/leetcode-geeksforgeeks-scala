package spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{Dataset, Encoders, SparkSession}
import org.apache.spark.sql.functions.{col, explode}
import spark.SparkJsonReader.dataset.exprEnc

object SparkJsonReader extends App {
  System.setProperty("hadoop.home.dir", "/")
  Logger.getLogger("org").setLevel(Level.ERROR)

  val sparkSession = SparkSession.builder().appName("local_test").master("local[*]")
    .getOrCreate()

  val df = sparkSession.read.option("multiline", "true").json("src/main/resources/sample.json")
  df.select("address").show(10, false)

  df.select("address.city").show(10, false)

  val address = df.select("address")


  // Optionally, convert DataFrame to Dataset[Person]
  val dataset: Dataset[DataTypeDetails] = df.as[DataTypeDetails](Encoders.product[DataTypeDetails])
  dataset.show()


  address.show(10, false)

  df.printSchema()



}
