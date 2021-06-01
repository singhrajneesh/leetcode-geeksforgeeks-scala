object QueriesOnPermutationWithKey1409 {
    def processQueries(queries: Array[Int], m: Int): Array[Int] = {
      val P=scala.collection.mutable.ArrayBuffer[Int]()
      val output=new Array[Int](queries.size)
      for(i<- 1 to m) P+=i
      for(j<- 0 to queries.length-1){
        var k=0
        val last=queries(j)
        while(queries(j)!=P(k) && k<P.size) k+=1
        output(j)=k
        for(l<- k to 1 by -1) P(l)=P(l-1)
        P(0)=last
      }
      output
    }
}
