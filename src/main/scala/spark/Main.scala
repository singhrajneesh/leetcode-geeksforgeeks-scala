package spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession


//Folder :-
///mera/data/employee/abc_it.csv
//
//
//Val df=SparkSession.read.format(“csv”).option(“header”,”true”).option(“inferSchema”,”true”).load(“abc*”)
//
//merchent_number,merchant_name,start_date,end_date,merchent_code
//55555,donald,2020-01-01,2020-04-95,d
//
//
//
//merchent_code,descripton
//A,active
//B,cancelled
//C,deleted
//
//Select merchant_description as merchent_code from table 1 left join table2 on (table1.merchnat_code=table2.merchant_code)
//
//
//Df a:- dfa id,name,mobileno
//Dfb :- id,pincode,address,city
//All columns when joining
//
//Select a.id,a.name,a.mobileno,b.pincode,b.address,b.city from table a left join table b on (a.id=b.id)
//
//Val df=dfa.join(dfb,“left”).dropColumns(“”)
//
//dfc.write.format(“parquet”).mode(overwrite).save(“”)
//dfc.write.mode(overwrite).saveAsTable(“”)
//
//df.createTempView(“table”)
//spark.sql(“insert overwrite table tbaleNAme select * from abc”)
//
//employee_id,employee_Code,employee_name,createts  table1
//Ind,us
//employee_id,employee_date,location,createts table2 reference table
//
//Employee joining us, India,uk,australia
//If India give first preference aus,us,uk
//
//
//Select a.*,b.employee_code from (
//Select * from (
//Select *,case when location=‘india’ then “ind”
//When location=‘aus’ then “aug”
//When location=‘us’ then “us”
//When location=‘ukl’ then “uk” end as precede
//from (
//Select employee_id,employee_date,location,createts,rank over(partition by employee_id,location order by createts) as ranking from table 2
//) where rankiing=1
//) where precede in (“us”,”uk”)
//) a
//inner join (
//Select * from (
//Select employee_id,employee_cocde,employee_name,rank over(partition by eployee_id,employee_cd order by createts) as ranking from table1
//) where ranking=1 ) b on (a.employee_code=b.employee_code and a.employee_id=b.employee_id)
//
//
//
//
//Select * from table 1 a where column in (select col3 from table2 where tabl1.a >tablle2.a)
//Select * from table 1 a where column in (select col3 from table2)

object Main {
  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "/")

    lazy val check  = 2

    val sparkSession = SparkSession.builder().appName("local_test").master("local[*]")
      .getOrCreate()

    Logger.getLogger("org").setLevel(Level.ERROR)
//    import org.apache.spark.sql.functions.to_timestamp
//    to_timestamp
    import sparkSession.implicits._

    val list = List(Seq(1, "one@gmail.com"),
      Seq(2, "two@gmail.com"),
      Seq(3, "three@gmail.com"),
      Seq(4, "four@gmail.com"))

    // Create RDD
    val rdd = sparkSession.sparkContext.parallelize(list)

    // Create DataFrame
    val df = rdd.map(row => (row.head.toString, row(1).toString )).toDF("rowId", "email")

    val first = sparkSession.read.option("header", "false").csv("src/main/resources/test1.txt")
      .withColumnRenamed("_c0", "word")

    first.createOrReplaceTempView("first")

    println(check + 3)
    sparkSession.read.option("header", "false").csv("src/main/resources/test2.txt")
      .withColumnRenamed("_c0", "word")
      .createOrReplaceGlobalTempView("second")


    sparkSession.sql("SELECT word FROM first LATERAL VIEW explode(split('word', ' ')) exploded_table AS word2")
      .show(10)

    df.show()

  }
}
