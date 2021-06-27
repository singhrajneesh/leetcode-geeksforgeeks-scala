package geeksforgeeks.tree

object CreationOfTree extends App {
  def creatingTreeNode(array: Array[Int]):TreeNode={
    val head=new TreeNode(array(0))
    for(i<- 0 to array.length-1 by 2)
        {
          println(head)
        }
    head
  }
}
