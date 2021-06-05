package leetcode.linkedlist

import scala.util.control.Breaks._

object LinkedListCycleII142 {

  def detectCycle(head: ListNode): ListNode = {
    if (head == null)
      return head
    var twoPointer = head
    var onePointer = head
    var flag = 0
    breakable {
      while (twoPointer != null && onePointer != null && twoPointer.next != null) {
        twoPointer = twoPointer.next.next
        onePointer = onePointer.next
        if (twoPointer == onePointer) {
          flag = 1
          break
        }
      }
    }
    if (flag == 1) {
      onePointer = head
      while (onePointer != twoPointer) {
        onePointer = onePointer.next
        twoPointer = twoPointer.next
      }
      return onePointer
    }
    null
  }


}
