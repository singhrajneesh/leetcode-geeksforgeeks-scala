package leetcode.linkedlist

object SwapNodesPairs24 {
  def swapPairs(head: ListNode): ListNode = {
    var first = head
    var second = head
    var tempFixedHead: ListNode = null
    var dummy = new ListNode(0)
    dummy.next = head
    if (head == null || head.next == null)
      return head
    while (second != null) {
      second = second.next
      if (second != null) {
        first.next = second.next
        second.next = dummy.next
        dummy.next = second
        if (tempFixedHead == null)
          tempFixedHead = second
        second = first.next
        dummy = first
        first = first.next
      }
    }
    tempFixedHead
  }

}
