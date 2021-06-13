package leetcode.stack

object OnlineStockSpan901 {

  /*class StockSpanner() {

    var stock1=scala.collection.mutable.Stack[Int]()
    var stock2=scala.collection.mutable.Stack[Int]()

    def next(price: Int): Int = {
      var count=1
      stock2.push(price)
      while(!stock1.isEmpty && price>=stock1.top)
      {
        stock2.push(stock1.pop)
        count+=1
      }

      while(!stock2.isEmpty) stock1.push(stock2.pop)

      count
    }

  }*/

  /**
   * Your StockSpanner object will be instantiated and called as such:
   * var obj = new StockSpanner()
   * var param_1 = obj.next(price)
   */
  //O(n) Solution
  case class Node(price: Int, var count: Int)
  class StockSpanner() {

    var stock = scala.collection.mutable.Stack[Node]()

    def next(price: Int): Int = {
      var newNode = Node(price, 1)
      if (!stock.isEmpty && price >= stock.top.price) {
        while (!stock.isEmpty && price >= stock.top.price) {
          var stockNode = stock.pop
          newNode.count = newNode.count + stockNode.count
        }
        stock.push(newNode)
      } else
        stock.push(newNode)
      newNode.count
    }
  }

  /**
   * Your StockSpanner object will be instantiated and called as such:
   * var obj = new StockSpanner()
   * var param_1 = obj.next(price)
   */
}
