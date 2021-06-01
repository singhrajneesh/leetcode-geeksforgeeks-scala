package array

object CountNumberTeams1395 {

  def numTeams(rating: Array[Int]): Int = {
    var count = 0
    for (i <- rating.indices)
      for (j <- i + 1 to rating.size - 1) {
        if (rating(j) > rating(i)) {
          for (k <- j + 1 to rating.size - 1) {
            if (rating(k) > rating(j))
              count += 1
          }
        }

        if (rating(j) < rating(i)) {
          for (k <- j + 1 to rating.size - 1) {
            if (rating(k) < rating(j))
              count += 1
          }
        }
      }
    count
  }
}
