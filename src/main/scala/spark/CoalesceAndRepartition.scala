package spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col


object CoalesceAndRepartition extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)

  val listOfDetails = Seq(1,2,3,4,5)

  val sparkSession = SparkSession.builder().appName("CoalesceAndRepartition").master("local[*]")
    .getOrCreate()

  val rdd = sparkSession.sparkContext.parallelize(listOfDetails)

  import sparkSession.implicits._

  val df  = rdd.toDF("Numbers")

  val dfCoalesece = df.coalesce(10)

  val repartition = df.repartition(col("Number"))

  val repartition2 = df.repartition(2)

  df.show(10, truncate = false)
}
