package ScalaConcepts

class School(x:Int,y:Int){
  def printingElements():Unit=println(x+" "+y)
}

object School {
    var xConstants=1
    val yConstants=2

  def apply(x:Int,y:Int): School = {
    new School(x,y)
  }
}

