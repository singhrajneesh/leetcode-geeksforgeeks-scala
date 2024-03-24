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
          print(tempRoot.num+" ")
          stack.push(tempRoot)
          tempRoot = tempRoot.left
        }
        if (stack.isEmpty)
          outer.break()
        tempRoot = stack.pop()
        tempRoot = tempRoot.right
      }
    )
  }

  val inorderTraversal: TreeNode => Unit = (root: TreeNode) => {
    var tempRoot = root
    val stack = scala.collection.mutable.Stack[TreeNode]()
    val breaking = new Breaks
    breaking.breakable(
      while (true) {
        while (tempRoot != null) {
          stack.push(tempRoot)
          tempRoot = tempRoot.left
        }
        if(stack.isEmpty)
          breaking.break
        val topOfStack = stack.pop()
        print(topOfStack.num+" ")
        tempRoot = topOfStack.right
      }
    )
  }

  //TODO not completed
  val postOrderTraversal:TreeNode=>Unit=(root:TreeNode)=>{
    var rootTemp=root
    val stack=scala.collection.mutable.Stack[TreeNode]()
    val breakeable=new Breaks
    breakeable.breakable(
      while(true){
        while(rootTemp!=null)
          {
            if(rootTemp.right!=null)
              stack.push(rootTemp.right)
            stack.push(rootTemp)
            rootTemp=rootTemp.left
          }

        if(stack.isEmpty)
          breakeable.break()

        var topOfStack=stack.pop()
        topOfStack=topOfStack.right

      }
    )
  }
}
