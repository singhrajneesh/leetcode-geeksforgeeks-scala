package leetcode.stack

object ValidateStackSequences946 {
  def validateStackSequences(pushed: Array[Int], popped: Array[Int]): Boolean = {
    var secondPointer = 0
    var stack = scala.collection.mutable.Stack[Int]()
    for (i <- pushed.indices) {
      stack.push(pushed(i))
      while (stack.nonEmpty && stack.top == popped(secondPointer)) {
        stack.pop
        secondPointer += 1
      }
    }
    for (i <- secondPointer until popped.length) {
      if (stack.isEmpty)
        return true
      else if (stack.top == popped(i))
        stack.pop
      else
        return false
    }
    true
  }
}
