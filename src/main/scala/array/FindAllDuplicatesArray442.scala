package array

object FindAllDuplicatesArray442 {
  def findDuplicates(nums: Array[Int]): List[Int] = {
    val mapCount=scala.collection.mutable.Map[Int,Int]()
    for(i <- nums.indices)
      mapCount+=(nums(i)->(mapCount.getOrElse(nums(i),0)+1))

    mapCount.filter(_._2==2).keys.toList
  }
}
