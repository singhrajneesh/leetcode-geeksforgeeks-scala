package leetcode.stack

import scala.util.control.Breaks

object LargestRectangleHistogram84 {
  def largestRectangleArea(heights: Array[Int]): Int = {
    //brute force approach
    /* var arrLeft = scala.collection.mutable.ArrayBuffer[Int]()
     var arrRight = scala.collection.mutable.ArrayBuffer[Int]()
     var breaking = new Breaks
     for (i <- 0 to heights.length - 1) {
       var j = i + 1
       breaking.breakable(
         while (j < heights.length) {
           if (heights(i) > heights(j)) {
             arrRight += j
             breaking.break
           }
           j += 1
         }
       )
       if (j == heights.length)
         arrRight += j
     }

     for (i <- 0 to heights.length - 1) {
       var j = i - 1
       breaking.breakable(
         while (j > (-1)) {
           if (heights(i) > heights(j)) {
             arrLeft += j
             breaking.break
           }
           j = j - 1
         })
       if (j == (-1))
         arrLeft += j
     }
     var max = 0
     for (i <- heights.length - 1 to 0 by -1) {
       var area = heights(i) * (arrRight(i) - arrLeft(i) - 1)
       if (area > max)
         max = area
     }
     max*/
    var stack = scala.collection.mutable.Stack[Int]()
    var size = heights.size
    var arrLeft = new Array[Int](size)
    var arrRight = new Array[Int](size)

    for (i <- 0 to heights.length - 1) {
      while (!stack.isEmpty && heights(stack.top) >= heights(i)) stack.pop
      arrLeft(i) = (if (stack.isEmpty) 0 else stack.top + 1)
      stack.push(i)
    }

    while (!stack.isEmpty) stack.pop

    for (i <- heights.length - 1 to 0 by -1) {
      println(stack)
      while (!stack.isEmpty && heights(stack.top) >= heights(i)) stack.pop
      arrRight(i) = (if (stack.isEmpty) heights.length - 1 else stack.top - 1)
      stack.push(i)
    }

    println(arrLeft.mkString(" "))
    println(arrRight.mkString(" "))
    var max = 0
    for (i <- heights.length - 1 to 0 by -1) {
      var area = heights(i) * (arrRight(i) - arrLeft(i) + 1)
      if (area > max)
        max = area
    }
    println(max)
    max
  }
}
