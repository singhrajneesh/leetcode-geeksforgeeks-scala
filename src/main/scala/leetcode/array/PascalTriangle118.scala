package leetcode.array

object PascalTriangle118 {
  def generate(numRows: Int): List[List[Int]] = {
    var result = List[List[Int]]()
    for (i <- 0 until numRows) {
      var temp = List[Int]()
      for (j <- 0 to i)
        temp :+= (if (j == 0 || j == i) 1 else result(i - 1)(j - 1) + result(i - 1)(j))
      result :+= temp
    }
    result
  }
}
