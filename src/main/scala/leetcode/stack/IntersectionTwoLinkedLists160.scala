package leetcode.stack

import leetcode.linkedlist.ListNode

object IntersectionTwoLinkedLists160 {
  def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {
    var first = headA
    var second = headB
    var stack1 = scala.collection.mutable.Stack[ListNode]()
    var stack2 = scala.collection.mutable.Stack[ListNode]()

    if (first == null || second == null)
      return null

    while (first != null || second != null) {
      if (first != null) {
        stack1.push(first)
        first = first.next
      }
      if (second != null) {
        stack2.push(second)
        second = second.next
      }
    }
    var temp: ListNode = null
    while (!stack1.isEmpty && !stack2.isEmpty) {
      if (stack1.top != stack2.top)
        return temp
      if (stack1.top == stack2.top)
        temp = stack1.top
      stack1.pop
      stack2.pop
    }

    return temp
  }

}
