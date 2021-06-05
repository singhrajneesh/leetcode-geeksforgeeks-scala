package leetcode.linkedlist

object MiddleLinkedList876 {
  def middleNode(head: ListNode): ListNode = {

    var slow = head
    var fast = head
    if (slow.next == null)
      return slow

    while (fast != null && fast.next != null) {
      fast = fast.next
      if (fast != null)
        fast = fast.next
      slow = slow.next
    }
    slow
  }
}
