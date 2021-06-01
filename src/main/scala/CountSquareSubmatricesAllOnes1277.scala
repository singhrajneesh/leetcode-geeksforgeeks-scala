object CountSquareSubmatricesAllOnes1277 {
  def countSquares(matrix: Array[Array[Int]]): Int = {
    var output = Array.ofDim[Int](matrix.length, matrix(0).length)
    var count = 0
    for (i <- output.indices; j <- output(0).indices) {
      if (i == 0 || j == 0)
        output(i)(j) = matrix(i)(j)
      else if (matrix(i)(j) == 0)
        output(i)(j) = 0
      else
        output(i)(j) = (output(i - 1)(j - 1)).min((output(i - 1)(j)).min(output(i)(j - 1))) + 1
    }

    for (i <- output.indices; j <- output(0).indices)
      count = count + output(i)(j)
    count
  }
}
