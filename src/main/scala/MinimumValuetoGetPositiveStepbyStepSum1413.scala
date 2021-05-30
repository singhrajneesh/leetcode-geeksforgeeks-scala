object MinimumValuetoGetPositiveStepbyStepSum1413 {
    def minStartValue(nums: Array[Int]): Int = {
      var i=0
      while(i>=0)
      {
        var j=0
        var value=i
        while(value>0 && j<nums.size){
          value=value+nums(j)
          j+=1
        }
        if(j==nums.size && value>0)
          return i
        i+=1
      }
       i
    }
}
