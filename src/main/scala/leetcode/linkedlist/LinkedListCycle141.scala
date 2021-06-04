package leetcode.linkedlist

object LinkedListCycle141 {
    def hasCycle(head: ListNode): Boolean = {
      var onePointer=head
      var twoPointer=head
      if(head==null)
        return false
      while(twoPointer!=null && twoPointer.next!=null && onePointer!=null)
      {
        twoPointer=twoPointer.next.next
        onePointer=onePointer.next
        if(twoPointer==onePointer)
          return true
      }
      false
    }
}
