package leetcode.linkedlist

object ReverseLinkedListII92 {

  def reverseBetween(head: ListNode, left: Int, right: Int): ListNode = {
    var start = left
    var end = right
    var k = 1
    var dummy = new ListNode(0)
    dummy.next = head
    var nodeBeforeSublist = dummy

    if (head == null || start == end)
      return head

    while (k < start) {
      nodeBeforeSublist = nodeBeforeSublist.next
      k += 1
    }

    var workingNode = nodeBeforeSublist.next

    while (start < end) {
      var nodeToBeExtracted = workingNode.next
      workingNode.next = nodeToBeExtracted.next
      nodeToBeExtracted.next = nodeBeforeSublist.next
      nodeBeforeSublist.next = nodeToBeExtracted
      start += 1
    }

    dummy.next
  }

}
