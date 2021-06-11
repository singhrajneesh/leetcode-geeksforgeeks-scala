package leetcode.linkedlist

object RotateList61 {
  def rotateRight(head: ListNode, k: Int): ListNode = {
    var tempHead = head
    var prev = head
    var curr = head
    if (head == null || head.next == null)
      return head
    for (i <- 0 to k - 1) {
      curr = curr.next
      while (curr.next != null) {
        prev = prev.next
        curr = curr.next
      }
      curr.next = tempHead
      prev.next = null
      tempHead = curr
      prev = curr
    }
    tempHead
  }

}
