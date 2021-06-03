package leetcode.array

object MeanofArrayAfterRemovingSomeElements1619 {
  def trimMean(arr: Array[Int]): Double = {
    val numToBeRemoved=(arr.size*0.05).toInt
    val newArr=quickSort(arr)
    for(i<- 0 to numToBeRemoved-1)
    {
      newArr(i)=0
      newArr(newArr.size-1-i)=0
    }
    newArr.sum/(newArr.size-(2*numToBeRemoved)).toDouble
  }

  def quickSort(arr:Array[Int]):Array[Int]={
    if(arr.size<=1)
      return arr
    else {
      val pivot=arr(arr.size/2)
      Array.concat(
        quickSort(arr.filter(_<pivot)),
        arr.filter(_==pivot),
        quickSort(arr.filter(_>pivot))
      )
    }
  }
}
