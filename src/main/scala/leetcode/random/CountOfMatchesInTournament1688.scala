package leetcode.random

object CountOfMatchesInTournament1688 {
  def numberOfMatches(n: Int): Int = {
    var numberOfMatches = 0
    var numberOfPlayer = n
    while(numberOfPlayer>1){
      if(numberOfPlayer%2==0)
      {
        numberOfMatches = numberOfMatches + (numberOfPlayer/2)
        numberOfPlayer = numberOfPlayer/2
      } else {
        numberOfMatches = numberOfMatches + ((numberOfPlayer-1)/2)
        numberOfPlayer = (numberOfPlayer-1)/2 + 1
      }
    }
    numberOfMatches
  }
}
