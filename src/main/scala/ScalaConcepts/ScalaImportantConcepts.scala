package ScalaConcepts

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



  //define an option
  val list=List(None,Some(1),Some(2),Some(3),None)
  //None,Some(1),Some(2),Some(3),None
  list.map(println(_))

  // null pointer exception
  //list.map(x=>println(x.get))

  //It will print only some values only as option are either one or zero elements means this will number
  // or inside of some and None
  list.map(x=>x.map(println))
  //Option is an abstract class. Option has two subclasses: Some and None.
  //All three (Option, Some and None) are defined in “scala” package like “scala.Option”.
  //Option is a bounded collection in Scala, which contains either zero or one element.
  //If Option contains zero elements that is None. If Option contains one element, that is Some.
  //Some is a case class and None is an Object. As both are case class/object,
  // we can use them in Pattern Matching very well.





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

  //Implicit val
  implicit val value=10
  //in this case x,y both are implicit variable
  def checkImplicit(implicit x:Int,y:Int):Int=x+y
  //this take the implicit values i:e x=10,y=10
  val implicitValue=checkImplicit
  println("this is the implicit value"+implicitValue)
  //this is i am explicitly providing
  val explicitOneValue=checkImplicit(10,25)
  println("this is the explicit value"+explicitOneValue)
  //We use currying to provide the one implicit value
  def withCurryingOneImplicitValues(x:Int)(implicit y:Int):Int=x+y
  //know the y will be automatically will be taking the y=10
  val implicitOneVariable=withCurryingOneImplicitValues(10)
  println(implicitOneVariable)








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
  //higher order function
  def sum(x: Int, y: Int) = x + y
  def multiply(x: Int, y: Int) = x * y
  def operation(f: (Int, Int) => Int, x: Int, y: Int): Int = f(x, y)
  println(operation(sum, 10, 3))
  println(operation(multiply, 10, 3))






  //Partial Function
  //Partial Function[Input,Output]
  val convert1to5InWords = new PartialFunction[Int, String] {
    val nums = Array("One", "Two", "Three", "Four", "Five")

    def apply(v1: Int): String = nums(v1 - 1)

    override def isDefinedAt(x: Int): Boolean = x < 6
  }
  println(if (convert1to5InWords.isDefinedAt(5)) convert1to5InWords(5) else "no this the value")





  //Currying
  def sumOfNumber(x: Int)(y: Int): Int = x + y
  println(sumOfNumber(1)(2))




  //Companion Object
  //First, a companion object and its class can access each other’s private members (fields and methods)

  //Second You can create new instances of certain classes without having to use the new keyword before the class name.
  //This functionality comes from the use of companion objects. What happens is that when you define an apply method in a companion object, it has a special meaning to the Scala compiler.
  val school=new School(School.xConstants,School.yConstants)
  school printingElements()



  //Anonymous Function
  val arr2=Array(1,2,4,5,6)
  //(x:Int)=>x>2 is an anonymous function
  val filtered=arr2.filter((x:Int)=>x>2)
  val functionLiteral=(x:Int)=>x>2
  val filteredWithFunction=arr2.filter(functionLiteral(_))



  //Auxiliary Constructor
  val defaultConstructor=new Pizza(2,"thick")
  val thinConstructor=new Pizza(4)



  //Either[String,Int]
  //Either is just like Option
  //Right is just like Some
  //Left is just like None, except you can include content with it to describe the problem
  def eitherDivideByZero(x:Int):Either[String,Int]={
    if(x==0) Left("This number is zero")
    else Right(100/x)
  }
  val ans=eitherDivideByZero(10)
   ans match {
     case Left(x)=>println("this is the left value of the either "+x)
     case Right(y)=>println("this is the right value of either  "+y)
   }
  eitherDivideByZero(0) match {
    case Left(x)=>println("this is the left value of the either "+x)
    case Right(y)=>println("this is the right value of either  "+y)
  }



  //Call by name and Call by value
  def giveNumber():Int={
    println("inside given number function")
    2
  }
  def callByValue(x:Int)={
    println("x1+= "+x)
    println("x2+= "+x)
  }
  def callByName(x: =>Int)={
    println("x1+= "+x)
    println("x2+= "+x)
  }
  //So you can see that in the call-by-value version, the side-effect of the passed-in function call
  // (giveNumber()) only happened once. However, in the call-by-name version, the side-effect happened twice.
  //This is because call-by-value functions compute the passed-in expression's value before calling
  // the function, thus the same value is accessed every time. Instead, call-by-name functions recompute
  // the passed-in expression's value every time it is accessed.
  callByValue(giveNumber())
  callByName(giveNumber())


  //As Scala supports Multi-Paradigm Programming(Both OOP and FP) and uses Actor Concurrency Model,
  // we can develop very highly Scalable and high-performance applications very easily.


  //Local function
  def gcdList(list:List[Int]):Int = {
    def gcd(x: Int, y: Int): Int =
      if (y == 0) x else gcd(y, x % y)
    list match {
      case Nil => 0
      case h :: t => gcd(h, gcdList(t))
    }
  }

  //Lazy val
  //Data type of volumeParamerOfCube variable will be Int
  private lazy val volumeParametersOfCube={
      val length=10
      val breadth=10
      10
  }

  def takeZeroArgument():Int={
    print("this is justchecking")
    30
  }
  def takeOneArgument(x:Int):Int={
    print(s"this is one argument + $x")
    x
  }
  def executeTheFunction( thisFunctionTakeZeroArgumentAndReturnUnit: =>Unit,str:String)=
    { println(thisFunctionTakeZeroArgumentAndReturnUnit)
      println(str)}
  executeTheFunction({
    takeOneArgument(10)

    takeZeroArgument()
  },"checkingNewType")

  executeTheFunction({
    takeOneArgument(10)
  },"checkingNewType")




  //  The primary difference between reduce and fold is that reduce doesn't take seed value but fold does require one to begin with.
  //  But, there is limitation to fold/reduce. They return a single value for a given collection. In this case though, we need the intermediate results of fold/reduce operations stored somewhere.
  //  That is exactly was scan operation does. For a collection, it performs the given operation starting with seed value(just like fold) and uses the result of the operation for next comparison. Finally, it returns a collection.



  val suming = (x:Int, y:Int ) => x+y
  val multiplying = (x:Int, y:Int) => x*y

  def takeFuntion(f :(Int,Int) => Int, x:Int, y:Int):Unit= {
    println(f(x,y))
  }

  takeFuntion(suming, 10 ,20)
  takeFuntion(multiplying, 10 ,20)
}


