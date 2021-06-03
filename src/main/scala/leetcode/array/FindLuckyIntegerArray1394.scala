package leetcode.array

object FindLuckyIntegerArray1394 {
  def findLucky(arr: Array[Int]): Int = {
    val mapOfFrequency=scala.collection.mutable.Map[Int,Int]()
    for(i <- 0 to arr.length-1){
      mapOfFrequency+=(arr(i)->(mapOfFrequency.getOrElse(arr(i),0)+1))
    }
    val filtered=mapOfFrequency.filter(x=>x._1==x._2)
    if(filtered.isEmpty)
      -1
    else filtered.toSeq.sortWith((x,y)=>x._1>y._1).head._1
  }
}
