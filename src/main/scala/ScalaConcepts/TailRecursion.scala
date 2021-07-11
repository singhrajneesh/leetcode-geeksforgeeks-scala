package ScalaConcepts

import scala.annotation.tailrec

object TailRecursion {
  //A recursive function is said to be tail recursive if the recursive call is the last thing done by
  // the function. There is no need to keep record of the previous state.

  //A tail-recursive function is just a function whose very the last action is a call to itself.
  // When you write your recursive function in this way, the Scala compiler can optimize the
  // resulting JVM bytecode so that the function requires only one stack frame — as opposed
  // to one stack frame for each level of recursion.

  // Function defined
  def factorial(n: Int): Int = {
    // Using tail recursion
    @tailrec def factorialAcc(acc: Int, n: Int): Int = {
      if (n <= 1)
        acc
      else
        factorialAcc(n * acc, n - 1)
    }

    factorialAcc(1, n)
  }

/*  @tailrec def factorial(n: Int): Int = {
    if (n == 1)
      1
    else
      n * factorial(n - 1)
  }*/


//    println(factorial(5))



}
