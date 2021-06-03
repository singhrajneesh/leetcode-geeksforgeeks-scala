package leetcode.array

object MinimumNumberOperationsReinitializePermutation1806 {
  def reinitializePermutation(n: Int): Int = {
    var perm = new Array[Int](n)
    var arr = new Array[Int](n)
    var arr1 = new Array[Int](n)

    for (i <- 0 to n - 1) perm(i) = i
    for (i <- 0 to n - 1) arr1(i) = i

    var flag = false
    var count = 0
    while (!flag) {
      for (i <- 0 to n - 1) {
        if (i % 2 == 0) arr(i) = arr1(i / 2)
        if (i % 2 == 1) arr(i) = arr1(n / 2 + (i - 1) / 2)
      }

      for (i <- 0 to n - 1) arr1(i) = arr(i)

      for (i <- 0 to n - 1)
        if (arr1(i) != perm(i))
          flag = true

      count = count + 1
      if (flag) flag = false else flag = true

    }

    count
  }
}
