package leetcode.linkedlist

object ReverseLinkedList206 {
  def reverseList(head: ListNode): ListNode = {
  //This is the iterative solution
    /*  var prev: ListNode = null
    var curr = head
    while (curr != null) {
      var nextOne = curr.next
      curr.next = prev
      prev = curr
      curr = nextOne
    }
    prev*/

    //this is the recursive solution
    if (head == null || head.next == null)
      return head
    var newHead = reverseList(head.next)
    head.next.next = head
    head.next = null

    return newHead
  }
}
