package com.ultrapower.spark.sogouQA

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import java.text.SimpleDateFormat
import java.util.Date

object join {
  def main(args: Array[String]) {
    if (args.length == 0) {
      System.err.println("Usage: join <file1>");
      System.exit(1)
    }

    val conf = new SparkConf().setAppName("join")
    val sc = new SparkContext(conf)
    val format = new SimpleDateFormat("yyyy-MM-dd")
    case class Register(d: Date, uuid: String, cust_id: String, lat: Float, lng: Float)
    case class Click(d: Date, uuid: String, landing_page: Int)
    val reg = sc.textFile(args(0)).map(_.split("\t")).map(r => (r(1), Register(format.parse(r(0)), r(1), r(2), r(3).toFloat, r(4).toFloat)))
    val clk = sc.textFile(args(1)).map(_.split("\t")).map(c => (c(1), Click(format.parse(c(0)), c(1), c(2).trim.toInt)))
    reg.join(clk).take(2).foreach(println)

    sc.stop()
  }

}