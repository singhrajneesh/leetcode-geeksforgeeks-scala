object ThreeConsecutiveOdds1550 {
  def threeConsecutiveOdds(arr: Array[Int]): Boolean = {
    for(i<-0 to arr.size-3){
      if(arr(i)%2!=0 && arr(i+1)%2!=0 && arr(i+2)%2!=0)
        return true
    }
    return false
  }
}
