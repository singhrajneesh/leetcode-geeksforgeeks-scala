package leetcode.array

object TwoSum1 {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val map=scala.collection.mutable.Map[Int,Int]()
    for(i<-0 to nums.size-1)
    {
      val sumleft=target-nums(i)
      val foundValue=map.getOrElse(sumleft,-1)
      if(foundValue!=(-1))
      {
        return Array(foundValue,i)
      }else
        map+=(nums(i)->i)
    }
    return Array()
  }
}
