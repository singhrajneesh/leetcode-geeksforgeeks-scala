package leetcode.dynamicprogramming


object LongestCommonSubsequence1143{


  def longestCommonSubsequenceUsingRecursion(str1: String, str1Length: Int, str2: String, str2Length: Int): Int = {
    if (str1Length == str1.length || str2Length == str2.length)
      return 0
    if (str1(str1Length) == str2(str2Length))
      return 1 + longestCommonSubsequenceUsingRecursion(str1, str1Length + 1, str2, str2Length + 1)

    math.max(longestCommonSubsequenceUsingRecursion(str1, str1Length + 1, str2, str2Length),
      longestCommonSubsequenceUsingRecursion(str1, str1Length, str2, str2Length + 1))
  }

  println(longestCommonSubsequenceUsingDynamicProgramming("abcde", "ace"))

  def longestCommonSubsequenceUsingDynamicProgramming(str1: String, str2: String): Int = {
    val str1Length = str1.length
    val str2Length = str2.length
    val twoDArray = Array.fill(str1Length + 1, str2Length + 1)(0)
    var max = 0
    for (i <- 1 to str1Length) {
      for (j <- 1 to str2Length) {
        twoDArray(i)(j) = if (str1(i - 1) == str2(j - 1))
          twoDArray(i - 1)(j - 1) + 1
        else
          math.max(twoDArray(i)(j - 1), twoDArray(i - 1)(j))
        if (max < twoDArray(i)(j))
          max = twoDArray(i)(j)
      }
    }
    max
  }
}
