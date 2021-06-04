package geeksforgeeks.linkedlist

object BasicOperationOnSinglyLinkedList extends App {


  val array = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)

  val deleteFirstNode = (head: ListNode) => head.next

  def insertNumberOnThePosition(head: ListNode, number: Int, position: Int): ListNode = {
    var temp = head
    var k = 1
    while (k < position) {
      k += 1
      temp = temp.next
    }
    val listNode = new ListNode(number)
    listNode.next = temp.next
    temp.next = listNode
    head
  }

  def addNumberInTheEndOfLinkedList(head: ListNode, number: Int): ListNode = {
    var temp = head
    while (temp.next != null) temp = temp.next
    temp.next = new ListNode(number)
    head
  }

  def addNumberInFrontOfLinkedList(head: ListNode, number: Int): ListNode = {
    val front = new ListNode(number)
    front.next = head
    front
  }


  def addNumbersInLinkedList(arr: Array[Int]): ListNode = {
    val head = new ListNode(arr(0))
    var temp = head
    for (i <- 1 to arr.length - 1) {
      temp.next = new ListNode(arr(i))
      temp = temp.next
    }
    head
  }

  def printLinkedList(head: ListNode): Unit = {
    var temp = head
    println("\n")
    while (temp != null) {
      print(temp.num + " ")
      temp = temp.next
    }
  }

  def getLengthOfLinkedList(head: ListNode): Int = {
    var temp = head
    var count = 0
    while (temp != null) {
      count = count + 1
      temp = temp.next
    }
    count
  }

  val deleteLastFromLinkedList = (head: ListNode) => {
    var temp = head
    var secondLast = head
    while (temp.next != null) {
      secondLast = temp
      temp = temp.next
    }
    secondLast.next = null
    head
  }

  val deleteFromPosition = (head: ListNode, position: Int) => {
    var k = 0
    var temp = head
    while (k < position) {
      temp = temp.next
      k += 1
    }
    val tempNext = temp.next
    temp.next = tempNext.next
    head
  }

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
