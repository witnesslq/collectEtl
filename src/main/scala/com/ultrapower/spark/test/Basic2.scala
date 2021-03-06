package com.ultrapower.spark.test
class Basic2 {
  
}
/*
class Persion{
  var name:String=_ //会生成getter和setter方法
  val age = 10 //只会生成getter方法
  private[this] val gender = "male" 
}
*/
//1、主构造器直接跟在类名后面，主构造器中的参数，最后会被编译成字段
//2、主构造器执行的时候，会执行类中的所有语句
//3、假设参数声明时不带val和var，那么相当于private[this] !!!
class Persion(val name : String, val age : Int){
  println("this is the primary constructer!") 
  var gender : String = _
  val school = "ZJU"
  //1、附属构造器名称为this
  //2、每一个附属构造器必须首先调用已经存在的子构造器或者附属构造器
  def this(name : String, age : Int, gender : String){
    this(name, age)
    this.gender = gender
  } 
}

class Student(name : String, age : Int, val major : String) extends Persion(name, age){
  println("This is this subclass of Persion, major is :"+major)
  
  override val school  = "BJU" 
  override def toString = "Override to toString..."
}

object Basic2{ 
  def main(args: Array[String]){
    /*
    val p = new Persion;
    p.name = "Jack"
    println(p.name + ":" + p.age)
    */
    /*
    val p = new Persion("Jacky", 20, "male")
    println(p.name + ":" + p.age + ":" + p.gender)
    */ 
    
    val s = new Student("Justin", 30, "Math")
    println(s.toString())
  }
}