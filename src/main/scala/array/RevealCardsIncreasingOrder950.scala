package array

import scala.collection.mutable

object RevealCardsIncreasingOrder950 {

    def deckRevealedIncreasing(deck: Array[Int]): Array[Int] = {
      val arr=deck.sortWith((x,y)=>x<y)
      //quickSort(deck)
      var output=new Array[Int](deck.size)
      var que=mutable.Queue[Int]()
      for(i<-deck.indices) que+=i
      for(i<- deck.indices) {
        val front=que.dequeue
        val newBack=if(que.nonEmpty) que+=que.dequeue
        output(front)=arr(i)
      }
      output
    }

    def quickSort(deck:Array[Int]):Array[Int]={
      if(deck.size<=1)
        return deck
      else{
        val pivot=deck(deck.size/2)
        Array.concat(
          quickSort(deck.filter(_<pivot))
          ,quickSort(deck.filter(_==pivot))
          ,quickSort(deck.filter(_>pivot))
        )
      }
    }

}
