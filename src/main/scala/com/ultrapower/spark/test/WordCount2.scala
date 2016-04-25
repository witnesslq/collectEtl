
package com.ultrapower.spark.test

import org.apache.spark.rdd.RDD.rddToOrderedRDDFunctions
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
  
object WordCount2 {  
  def main(args: Array[String]) {  
    if (args.length == 0) {  
      System.err.println("Usage: WordCount2 <file1>")  
      System.exit(1)  
    }  
  
    val conf = new SparkConf().setAppName("WordCount2")  
    val sc = new SparkContext(conf)  
    sc.textFile(args(0)).flatMap(_.split(" ")).map(x => (x, 1)).reduceByKey(_ + _).map(x=>(x._2,x._1)).sortByKey(false).map(x=>(x._2,x._1)).take(10).foreach(println)  
    sc.stop()
  }  
}  