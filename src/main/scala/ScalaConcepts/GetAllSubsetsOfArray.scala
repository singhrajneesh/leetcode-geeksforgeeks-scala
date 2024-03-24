package ScalaConcepts

object GetAllSubsetsOfArray extends App {
  def getAllSubset(nums: Array[Int]): scala.collection.mutable.ArrayBuffer[scala.collection.mutable.ArrayBuffer[Int]] = {
    val n = nums.length;
    val resultArray = scala.collection.mutable.ArrayBuffer[scala.collection.mutable.ArrayBuffer[Int]]()
    var i = 0
    while (i < (1 << n)) {
      val tempArrayBuffer = scala.collection.mutable.ArrayBuffer[Int]()
      var j = 0
      while (j < n) {
        if ((i & (1 << j)) != 0) {
          tempArrayBuffer+= nums(j)
        }
        j += 1
      }
       resultArray += tempArrayBuffer
      i += 1
    }
    resultArray
  }

  println(getAllSubset(Array(1,2,3)))
}
