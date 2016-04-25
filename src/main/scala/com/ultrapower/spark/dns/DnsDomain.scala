package com.ultrapower.spark.dns

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext

object DnsDomain {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    val sc = new SparkContext(conf)
    val file = sc.textFile("hdfs://master:9000//ws/dns_test.db/dns_log/dt=20160329/851_01_201602020920.txt.gz")
    val count = file.flatMap(line => line.split("\n")).map(line => line.split("\\|")(1)).map(word => (word, 1)).reduceByKey(_+_)
    count.collect().foreach(println)
    sc.stop
  }
}