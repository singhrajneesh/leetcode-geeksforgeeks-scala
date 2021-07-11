package leetcode.array
import scala.util.control.Breaks._
object RemoveElement27 {
  def removeElement(nums: Array[Int], `val`: Int): Int = {
    var temp = `val`
    var count = nums.size - 1
    var i = 0
    if ((nums.size == 1 && nums(0) == temp) || nums.size == 0)
      return -1

    breakable {
      while (i <= nums.size - 1) {
        if (i > count)
          break
        else if (nums(i) == temp) {
          while (count > 0 && nums(count) == temp) count -= 1
          if (count <= i)
            break
          nums(i) = nums(count)
          nums(count) = temp
          count -= 1
        }
        i += 1
      }

    }
    i
  }
}
