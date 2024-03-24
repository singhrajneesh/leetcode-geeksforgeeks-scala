package geeksforgeeks.tree

import scala.util.control.Breaks._
import geeksforgeeks.tree.TraversingTree.{inorderTraversal, postOrderTraversal, preOrderTraversal}

object CreationOfTree extends App {
  val inorder = Array(4, 2, 5, 1, 6, 7, 3, 8)
  val preorder = Array(1, 2, 4, 5, 3, 7, 6, 8)

  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    val preStart = 0
    val preEnd = preorder.length - 1
    val inStart = 0
    val inEnd = inorder.length - 1
    construct(preorder, preStart, preEnd, inorder, inStart, inEnd)
  }

  def construct(preorder: Array[Int], preStart: Int, preEnd: Int, inorder: Array[Int], inStart: Int, inEnd: Int): TreeNode
  = {
    if (preStart > preEnd || inStart > inEnd) return null
    val `val` = preorder(preStart)
    val p = new TreeNode(`val`)
    //find parent element index from inorder
    var k = 0

    breakable {
      for (i <- 0 until inorder.length) {
        if (`val` == inorder(i)) {
          k = i
          break //todo: break is not supported
        }
      }
    }
    p.left = construct(preorder, preStart + 1, preStart + (k - inStart), inorder, inStart, k - 1)
    p.right = construct(preorder, preStart + (k - inStart) + 1, preEnd, inorder, k + 1, inEnd)
    p
  }


  val tree = buildTree(preorder, inorder)
  //          1
  //         /  \
  //        2    3
  //       / \  / \
  //      4  5  7  8
  //           /
  //          6

  preOrderTraversal(tree)
  println("\n")
  inorderTraversal(tree)
  println("\n")
  //var list=new List[Int]()
  //todo it is still not completed
  //todo postOrderTraversal(tree)

  def helper(root:TreeNode, list1:List[Int]):List[Int]={
    var list=list1
    if(root!=null)
    {
      helper(root.left,list)
      list:+=root.num
      helper(root.right,list)
    }
    list
  }
}
