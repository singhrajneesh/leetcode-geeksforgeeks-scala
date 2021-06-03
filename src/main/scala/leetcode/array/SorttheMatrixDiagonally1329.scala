package leetcode.array

object SorttheMatrixDiagonally1329 {
  def diagonalSort(mat: Array[Array[Int]]): Array[Array[Int]] = {
    //(key=subtract of indices and value=values of matrix)
    val mapOfList=scala.collection.mutable.Map[Int,scala.collection.mutable.ArrayBuffer[Int]]()
    var output=Array.ofDim[Int](mat.length,mat(0).length)
    for(i<-mat.indices; j<- mat(0).indices)
      mapOfList+=((i-j)->(mapOfList.getOrElse((i-j),scala.collection.mutable.ArrayBuffer[Int]())+=mat(i)(j)) )

    for((k,v)<-mapOfList) mapOfList+=(k->v.sortWith((x,y)=>(x<y)))

    for(i<-mat.indices; j<- mat(0).indices)
    {
      output(i)(j)=mapOfList.getOrElse((i-j),new scala.collection.mutable.ArrayBuffer[Int]).head
      mapOfList+=((i-j)->(mapOfList.getOrElse((i-j),new scala.collection.mutable.ArrayBuffer[Int])-=output(i)(j)))
    }
    output
  }
}
