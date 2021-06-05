package leetcode.linkedlist

object IntersectionTwoLinkedLists160 {
    def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {
      var lengthA = 0
      var lengthB = 0
      var tempA = headA
      var tempB = headB

      while (tempA != null || tempB != null) {
        if (tempA != null) {
          lengthA += 1
          tempA = tempA.next
        }
        if (tempB != null) {
          lengthB += 1
          tempB = tempB.next
        }
      }
      tempA = headA
      tempB = headB

      if (lengthA >= lengthB) {
        var diff = lengthA - lengthB
        if (diff == 0 & tempA == tempB)
          return tempA
        if (diff > 0)
          for (i <- 0 to diff - 1) tempA = tempA.next
      }
      else {
        var diff = lengthB - lengthA
        for (i <- 0 to diff - 1) tempB = tempB.next
      }
      while (tempA != null && tempB != null) {
        if (tempA == tempB)
          return tempA
        tempA = tempA.next
        tempB = tempB.next
      }
      return null
    }

}
