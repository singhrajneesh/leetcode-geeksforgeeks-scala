package array

object CountLargestGroup1399 {
    def countLargestGroup(n: Int): Int = {
      val mapOfSummation=scala.collection.mutable.Map[Int,Int]()
      for(i <- 1 to n){
        var num=i
        var sum=0
        while(num>0){
          sum=sum+(num%10)
          num=num/10
        }
        mapOfSummation+=(sum->(mapOfSummation.getOrElse(sum,0)+1))
      }
      val count=mapOfSummation.toSeq.sortWith((x,y)=>x._2>y._2).head._2
      mapOfSummation.count(_._2 == count)
    }
}
