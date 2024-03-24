package leetcode.dynamicprogramming

object FactorialOfNumber{
  def factorialOfNumber(numeric: Int): Int = {
    if (numeric == 1) {
      return 1
    }
    else if (numeric == 2) {
      return 2
    } else if (storeValue(numeric-1) != -1) {
      return storeValue(numeric-1)
    }
    storeValue(numeric-1) = numeric * factorialOfNumber(numeric - 1)
    storeValue(numeric-1)
  }
  val numberToTest = 6
  val storeValue = Array.fill(numberToTest)(-1)
  System.out.print(factorialOfNumber(numberToTest))
}
