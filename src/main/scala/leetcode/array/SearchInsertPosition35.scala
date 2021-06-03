package leetcode.array

object SearchInsertPosition35 {
  def searchInsert(nums: Array[Int], target: Int): Int = {
    for (i <- nums.indices)
      if (nums(i) >= target)
        return i

    return nums.length
  }
}
