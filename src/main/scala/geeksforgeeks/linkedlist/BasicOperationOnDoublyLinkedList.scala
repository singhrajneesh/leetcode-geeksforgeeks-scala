package geeksforgeeks.linkedlist

object BasicOperationOnDoublyLinkedList extends App {


  val deleteFirstNode = (head: DoublyListNode) => {
    val next = head.right
    next.left = null
    next
  }

  def insertNumberOnThePosition(head: DoublyListNode, number: Int, position: Int): DoublyListNode = {
    var temp = head
    var k = 1
    while (k < position) {
      k += 1
      temp = temp.right
    }
    val listNode = new DoublyListNode(number)
    val next = temp.right
    listNode.right = temp.right
    listNode.left = temp
    temp.right = listNode
    next.left = listNode
    head
  }

  def addNumberInTheEndOfLinkedList(head: DoublyListNode, number: Int): DoublyListNode = {
    var temp = head
    while (temp.right != null) temp = temp.right
    val newNode = new DoublyListNode(number)
    temp.right = newNode
    newNode.left = temp
    head
  }

  def addNumberInFrontOfLinkedList(head: DoublyListNode, number: Int): DoublyListNode = {
    val front = new DoublyListNode(number)
    front.right = head
    head.left = front
    front
  }


  def addNumbersInLinkedList(arr: Array[Int]): DoublyListNode = {
    val head = new DoublyListNode(arr(0))
    var temp = head
    for (i <- 1 to arr.length - 1) {
      val newNode = new DoublyListNode(arr(i))
      temp.right = newNode
      newNode.left = temp
      temp = temp.right
    }
    head
  }

  def printLinkedList(head: DoublyListNode): Unit = {
    var temp = head
    println("\n")
    while (temp != null) {
      print(temp.num + " ")
      temp = temp.right
    }
  }

  def getLengthOfLinkedList(head: DoublyListNode): Int = {
    var temp = head
    var count = 0
    while (temp != null) {
      count = count + 1
      temp = temp.right
    }
    count
  }

  val deleteLastFromLinkedList = (head: DoublyListNode) => {
    var temp = head
    var secondLast = head
    while (temp.right != null) {
      secondLast = temp
      temp = temp.right
    }
    secondLast.right = null
    head
  }

  val deleteFromPosition = (head: DoublyListNode, position: Int) => {
    var k = 0
    var temp = head
    while (k < position) {
      temp = temp.right
      k += 1
    }
    val tempNext = temp.right
    val tempPrev=temp.left
    tempNext.left = tempPrev
    tempPrev.right=tempNext
    head
  }

  val array = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
  var head = addNumbersInLinkedList(array)
  println(getLengthOfLinkedList(head))
  printLinkedList(head)
  head = addNumberInFrontOfLinkedList(head, 100)
  printLinkedList(head)
  head = addNumberInTheEndOfLinkedList(head, 2000)
  printLinkedList(head)
  head = insertNumberOnThePosition(head, 20, 4)
  printLinkedList(head)
  head = deleteFirstNode(head)
  printLinkedList(head)
   head = deleteLastFromLinkedList(head)
  printLinkedList(head)
  head = deleteFromPosition(head, 3)
  printLinkedList(head)


}
