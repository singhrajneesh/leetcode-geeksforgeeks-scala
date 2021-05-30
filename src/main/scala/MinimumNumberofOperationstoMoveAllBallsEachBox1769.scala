object MinimumNumberofOperationstoMoveAllBallsEachBox1769 {
  def minOperations(boxes: String): Array[Int] = {
    var output=new Array[Int](boxes.size)
    for(i<- 0 to boxes.size-1){
      var sum=0
      for(j<- 0 to boxes.size-1){
        if(boxes(j)=='1' && i!=j)
        {
          sum = sum + (if(i>j)
            i-j
          else j-i)
        }
      }
      output(i)=sum
    }
    output
  }

}
