
package com.ultrapower.spark.test

class Basic {
  
}

object Basic{
  def hello(name:String = "Scala"): String = {
    return "hello: "+name
  }
  
  def hello(name:String, value:Int):String={
    return "我叫："+name+" 几年："+value+"岁"
  }
  
  def helloScala(){
    println("hello Scala !!!")
  }
  
  def add = (x : Int, y : Int) => x + y
  
  def add2(x:Int)(y:Int) = x + y
  
  def printEveryChar(c:String*) = {
    c.foreach { x => println(x) }
  }
  
  def main(args: Array[String]){
    //print(hello())
    //print(hello("小明",23))
    //helloScala()
    //print(add(1,2))
    //print(add2(1)(2))
    //printEveryChar("a","b","c","d")
   
    /*
    //判断
    val x = 1;
    val a = if(x > 0) 1 else 0
    print(a)
    */
    /*
    //while循环
    var (n,r) = (10,0)
    while (n>0) {
      r = r + n
      n = n - 1
    }
    println(r)
    */
    
    //foreach循环
    /*
    //for循环
    for(i<-1 until 10){ //a.b("xxx") == a b "xxx"
      println(i)
    }
    */
    
    /*
    //循环判断
    for(i<-1 to 10 if i % 2 == 0){
      println(i)
    }
    */
    
    
    
  }
}