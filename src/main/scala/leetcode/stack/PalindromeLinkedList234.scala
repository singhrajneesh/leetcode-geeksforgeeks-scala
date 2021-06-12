package leetcode.stack

import leetcode.linkedlist.ListNode

object PalindromeLinkedList234 {
  def isPalindrome(head: ListNode): Boolean = {
    var fast = head
    var slow = head
    var stack = scala.collection.mutable.Stack[Int]()
    while (fast != null && fast.next != null) {
      stack.push(slow.x)
      fast = fast.next.next
      slow = slow.next
    }
    if (fast != null)
      slow = slow.next
    while (slow != null) {
      val temp = stack.pop
      if (temp != slow.x)
        return false
      slow = slow.next
    }
    true
  }
}
