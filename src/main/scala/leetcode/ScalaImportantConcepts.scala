package leetcode

import scala.util.control.Breaks

object ScalaImportantConcepts extends App {
  //Option
  val obj = checkOption(Some("hi"))
  val none = checkOption(None)
  val check = if (obj.isEmpty) println("is empty") else 1
  println(check)
  println(none)

  def checkOption(str: Option[String]): Option[String] = {
    str match {
      case Some(_) => None
      case None => str
    }
  }

  //Implicit
  val strToInt = "abs".createInt
  println("it is the string to int " + strToInt)
  println("1".createInt)

  implicit class makeStringToInt(str: String) {
    def createInt: Int = {
      try
        str.toInt
      catch {
        case _: Throwable => -1
      }
    }
  }

  //for yield and guards
  val arr = Array(1, 2, 4, 5, 6, 7, 8, 9)
  val yielded = for (i <- arr.indices if i > 2) yield arr(i) * arr(i)
  yielded.map(x => print(x + " "))
  println(" ")
  val increAndDecre = for (i <- arr.indices if arr(i) > 4) yield {
    val incre = arr(i) + 100
    val decre = incre - 10
    decre
  }
  increAndDecre.map(x => print(x + " "))

  //Inner and Outer Break

  import scala.util.control.Breaks

  val inner = new Breaks
  val outer = new Breaks
  inner.breakable(
    for (i <- 0 to 10) {
      outer.breakable(
        for (j <- 0 to 10) {
          if (i > 2) {
            println(j)
            inner.break
          }
        }
      )
    }
  )

  //Partially Applied Function
  val partiallyAppliedFunction = (x: Int, y: Int, z: Int) => x + y + z
  val z = partiallyAppliedFunction(1, 2, _: Int)
  println(z(10))

  //Functional Programming
  //parameterName:(ParameterType(S))=>returnType
  def twoParameterFunction(x: Int, y: Int): Int = {
    x + y + 100
  }

  def haveFunction(f: (Int, Int) => Int): Unit = {
    println(f(10, 15))
  }

  haveFunction(twoParameterFunction)

  //Partial Function
  //Partial Function[Input,Output]
  val convert1to5InWords = new PartialFunction[Int, String] {
    val nums = Array("One", "Two", "Three", "Four", "Five")

    def apply(v1: Int): String = nums(v1 - 1)

    override def isDefinedAt(x: Int): Boolean = x < 6
  }
  println(if (convert1to5InWords.isDefinedAt(5)) convert1to5InWords(5) else "no this the value")
}
