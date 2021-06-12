package leetcode.stack

object BuildArrayWithStackOperations1441 {
  def buildArray(target: Array[Int], n: Int): List[String] = {
    var output = List[String]()
    var second = 0
    for (i <- 1 to n) {
      if (second == target.size)
        return output
      if (target(second) == i) {
        output = output :+ "Push"
        second += 1
      }
      else {
        output = output :+ "Push"
        output = output :+ "Pop"
      }
    }
    output
  }
}
