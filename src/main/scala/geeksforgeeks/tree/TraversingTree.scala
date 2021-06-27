package geeksforgeeks.tree

import scala.util.control.Breaks

object TraversingTree {
  def preOrderTraversal(root: TreeNode): Unit = {
    var tempRoot = root
    val stack = scala.collection.mutable.Stack[TreeNode]()
    val outer = new Breaks
    outer.breakable(
      while (true) {
        while (tempRoot != null) {
          println(tempRoot.num)
          stack.push(tempRoot)
          tempRoot = tempRoot.left
        }
        if (stack.isEmpty)
          outer.break()
        tempRoot=stack.pop()
        tempRoot=tempRoot.right
      }
    )
  }
}
