
package com.ultrapower.spark.test
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions

/**
 * 统计字符出现次数
 */
object WordCount {
  def main(args: Array[String]) {
  if (args.length < 1) {
    System.err.println("Usage: <file>")
    System.exit(1)
  }
  val conf = new SparkConf()
  val sc = new SparkContext(conf)
  val line = sc.textFile(args(0))
  line.flatMap(_.split("\t")).map((_, 1)).reduceByKey(_+_).collect.foreach(println)
  
  sc.stop
  }
}