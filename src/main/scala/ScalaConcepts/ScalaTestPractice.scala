package ScalaConcepts

import ScalaConcepts.ScalaImportantConcepts.school

import scala.util.control.Breaks

object ScalaTestPractice extends App {


  //Option
  //  checkOption(Some("this is some"))
  //  checkOption(Option("This is option"))
  //  checkOption(None)
  def checkOption(str: Option[String]): Unit = {
    str match {
      case Some(_) => println(str)
      case None => println("This is none")
    }
  }


  //List with some option none
  val listOfSomeNone = List(Some(1), Some("2"), Some('c'), None, Option("This is option"))

  // listOfSomeNone.map(println)

  //  listOfSomeNone.map(x=>x.map(println))


  //Implicit class to string method

  val convertedVal: Int = "1".convertToInt

  implicit class checkString(str: String) {
    def convertToInt: Int = {
      try {
        str.toInt
      } catch {
        case _: Throwable => 1
      }
    }
  }

  //Implicit val
  implicit val value = 10

  //in this case x,y both are implicit variable
  def checkImplicit(implicit x: Int, y: Int): Unit = {
    println(x + y)
  }

  //checkImplicit
  //this take the implicit values i:e x=10,y=10
  //checkImplicit(100,100)
  //this is i am explicitly providing
  def checkImplicitCurrying(x: Int)(implicit y: Int): Unit = {
    println(x + y)
  }
  //We use currying to provide the one implicit value
  //know the y will be automatically will be taking the y=10
  //checkImplicitCurrying(100)

  //for yield and guards

  val arr = Array(1, 2, 3, 4, 5, 6)
  for (i <- 0 to arr.length - 1 if arr(i) > 4) {
    // println(arr(i))
  }

  val yieldeded = for (i <- 0 to arr.length - 1 if i >= 4) yield arr(i) * 100

  val yieldeded2 = for (i <- 0 to arr.length - 1 if i >= 4) yield {
    arr(i) * 100
    arr(i) * 1000
  }

  //println(yieldeded2)


  //Inner and Outer Break

  import scala.util.control.Breaks._

  val inner = Breaks
  val outer = Breaks
  outer.breakable {
    for (a <- arr) {
      inner.breakable {
        while (a != 0) {
          outer.break()
        }
      }
    }
  }

  //Partially Applied Function
  val simpleFunction = (x: Int, y: Int, z: Int) => x + y + z
  val partialAppliedFunction = simpleFunction(10, 20, _: Int)
  //println(partialAppliedFunction(30))


  //Functional Programming
  //parameterName:(ParameterType(S))=>returnType
  def functionWithParam(f: (Int, String) => Unit): Unit = {
    f(10, "number")
  }

  def funtionWithIntAndStringParam(num: Int, s: String): Unit = {
    //  println(num + s)
  }

  functionWithParam(funtionWithIntAndStringParam)

  val sum = (x: Int, y: Int) => x + y
  val multiply = (x: Int, y: Int) => x * y
  val divide = (x: Int, y: Int) => x / y

  def highOrderFunction(f: (Int, Int) => Int, x: Int, y: Int): Unit = {
    println(f(x, y))
  }

  //  highOrderFunction(sum, 10, 12)
  //  highOrderFunction(multiply, 10, 20)
  //  highOrderFunction(divide , 10, 20)
  //


  //Partial Function
  //Partial Function[Input,Output]

  val convert1To5InWords = new PartialFunction[Int, String] {
    override def isDefinedAt(x: Int): Boolean = x > 10

    override def apply(v1: Int): String = v1.toString + "Converted"
  }
  //  println(if (convert1To5InWords.isDefinedAt(20)) convert1To5InWords.apply(23) else "This is check")

  //Currying
  def curry(x: Int)(y: Int) = x + y

  //Companion Object
  val school = School(School.xConstants, School.yConstants)


  //Anonymous Function
  val arr2 = Array(1, 23, 4, 56, 67)
  //this is anonymous function
  val filterFunction = (x: Int) => x > 10
  //println(arr2.filter(filterFunction(_)).mkString(" "))


  //Auxiliary Constructor


  //Either[String,Int]
  //Either is just like Option
  //Right is just like Some
  //Left is just like None, except you can include content with it to describe the problem
  def eitherRightOrLeft(x: Int): Either[Int, String] = {
    if (x < 10) Left(1) else
      Right("THis is right ")
  }
//  println(eitherRightOrLeft(9) match {
//    case Left(_) =>  "This is left"
//    case Right(_) =>  "This is right"
//  })

  //Call by name and Call by value


  //Local function


  //Lazy val
  //Data type of volumeParamerOfCube variable will be Int
  private lazy val volumeParametersOfCube={
    val length=10
    val breadth=10
    10
  }


  def takeZeroArgument():Int={
    print("this is justchecking \n")
    30
  }
  def takeOneArgument(x:Int):Int={
    print(s"this is one argument + $x \n")
    x
  }
  def executeTheFunction( thisFunctionTakeZeroArgumentAndReturnUnit: =>Unit,str:String)=
  { println(thisFunctionTakeZeroArgumentAndReturnUnit)
    println(str)
  }
  executeTheFunction({
    takeOneArgument(10)

    takeZeroArgument()
  },"checkingNewType")

  executeTheFunction(
    {
    takeOneArgument(10)
  },"checkingNewType")

}
