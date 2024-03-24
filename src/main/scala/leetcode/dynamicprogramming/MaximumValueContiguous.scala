package leetcode.dynamicprogramming

object MaximumValueContiguous extends App {

  //  The primary difference between reduce and fold is that reduce doesn't take seed value but fold does require one to begin with.
  //  But, there is limitation to fold/reduce. They return a single value for a given collection. In this case though, we need the intermediate results of fold/reduce operations stored somewhere.
  //  That is exactly was scan operation does. For a collection, it performs the given operation starting with seed value(just like fold) and uses the result of the operation for next comparison. Finally, it returns a collection.


  def maximumValueContiguous(input: Array[Int]): Int = {

    var maxSumOfNumber = 0
    for (i <- input.indices) {
      var currentSum = 0
      for (j <- i until input.length) {
        currentSum += input(j)
        if (currentSum > maxSumOfNumber)
          maxSumOfNumber = currentSum
      }
    }
    maxSumOfNumber
  }

  def maximumValueContiguousFromCoreScala(input: Array[Int]): Int = {
    // set seed value for scan operation
    // seed's role here is to nullify any addition or subtraction
    // seed will always be negative so that max(seed, num(0)) will be nums(0)
    val seed = (-1) * math.abs(input(0))

    // find the maximum of acc_sum+nums(i), nums(i) using scan operation
    // scan is similar to fold but it returns a Collection instead of an element
    // https://alvinalexander.com/scala/how-to-walk-scala-collections-reduceleft-foldright-cookbook/
    val maxAtEachNum = input.scan(seed)((a, b) => {
      math.max(a + b, b)
    })

    // return the maximum element from the result
    // similar to max_sum = max(max_sum, acc_sum)
    // can also use maxAtEachNum.max
    maxAtEachNum.reduce(_ max _)
  }


  def maximumValueContiguousFromCoreScalaOneLiner(input: Array[Int]): Int = {
    input.scan((-1) * math.abs(input(0)))((a, b) => {
      math.max(a + b, b)
    }).max
  }

  println(maximumValueContiguousFromCoreScala(Array.apply(-2, 1, -3, 4, -1, 2, 1, -5, 4)))

}
