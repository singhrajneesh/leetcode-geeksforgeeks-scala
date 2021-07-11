package geeksforgeeks.tree

object CreationOfTree extends App {
  val array = Array(1, 2, 3, 4, 5, 6, 7, 8, 9,0)


  def creatingTreeNode(array: Array[Int]): TreeNode = {
    var stack=scala.collection.mutable.Stack[TreeNode]()
    var stack2=scala.collection.mutable.Stack[TreeNode]()
    var i=1
    var tempHead=new TreeNode(array(0))
    stack.push(tempHead)
    while(stack.nonEmpty){
      val tempNode=stack.pop()
    }
    tempHead
  }

  TraversingTree.preOrderTraversal(creatingTreeNode(array))
}
