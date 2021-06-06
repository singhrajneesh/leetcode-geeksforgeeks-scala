package leetcode.linkedlist

object MergeTwoSortedLists21 {
  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    var result: ListNode = null
    if (l1 == null) return l2
    if (l2 == null) return l1
    if (l1.x <= l2.x) {
      result = l1
      result.next = mergeTwoLists(l1.next, l2)
    } else {
      result = l2
      result.next = mergeTwoLists(l2.next, l1)
    }
    return result
  }
}
