package leetcode.array

object SpecialPositionsBinaryMatrix1582 {
    def numSpecial(mat: Array[Array[Int]]): Int = {
      val col=mat(0).length
      val row=mat.length
      var specialPos=0
      for(i <- 0 to row-1)
      {
        for(j<- 0 to col-1)
        {
          if(mat(i)(j)==1)
            specialPos=specialPos+checkSpecialPosition(mat,i,j)
        }
      }
      specialPos
    }

    def checkSpecialPosition(mat:Array[Array[Int]],i:Int,j:Int):Int={
      for(k<- 0 to mat(0).length-1)
        if(mat(i)(k)==1 && k!=j)
          return 0
      for(k<- 0 to mat.length-1)
        if(mat(k)(j)==1 && k!=i)
          return 0
      1
    }

}
