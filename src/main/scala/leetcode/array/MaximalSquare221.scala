package leetcode.array

object MaximalSquare221 {
  def maximalSquare(matrix: Array[Array[Char]]): Int = {
    var dp = Array.ofDim[Int](matrix.length + 1, matrix(0).length + 1)
    var maxSquareSize = 0
    for (i <- 0 to matrix.length - 1) {
      for (j <- 0 to matrix(0).length - 1) {
        // If the cell contains a '1', it is a potential part of a square.
        if (matrix(i)(j) == '1') {
          // The size of the square ending at (i, j) is 1 plus the minimum of
          // the size of the squares above, to the left, and diagonally above and to the left.
          dp(i + 1)(j + 1) = Math.min(Math.min(dp(i)(j + 1), dp(i + 1)(j)), dp(i)(j)) + 1;

          // Update the maximum size encountered so far.
          maxSquareSize = Math.max(maxSquareSize, dp(i + 1)(j + 1));
        }
      }
    }
    maxSquareSize * maxSquareSize
  }
}
