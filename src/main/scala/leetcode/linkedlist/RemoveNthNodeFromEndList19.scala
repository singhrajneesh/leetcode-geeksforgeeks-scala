package leetcode.linkedlist

object RemoveNthNodeFromEndList19 {
  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    //Other solution is storing in Map with key is position and removing it
    var fast = head
    var slow = head
    var prev = slow
    for (i <- 1 to n - 1)
      fast = fast.next

    while (fast.next != null) {
      prev = slow
      slow = slow.next
      fast = fast.next
    }

    if (slow == head)
      return slow.next
    else
      prev.next = slow.next

    head
  }
}
