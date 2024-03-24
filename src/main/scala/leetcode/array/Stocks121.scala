package leetcode.array

object Stocks121 {
  def maxProfit(prices: Array[Int]): Int = {
    var left = 0
    var right = 1
    var max = 0
    while (left < prices.length && right < prices.length) {
      if (prices(right) - prices(left) <= 0) {
        left = right
        right = left + 1
      } else if (prices(right) - prices(left) > 0) {
        if (max < prices(right) - prices(left)) {
          max = prices(right) - prices(left)
        }
        right += 1
      }
      println(right)
    }
    max
  }
}
