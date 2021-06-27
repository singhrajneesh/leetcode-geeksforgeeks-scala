package ScalaConcepts

class Pizza(crustThickness:Int,crustType:String) {
  def this(crustThickness:Int)=this(crustThickness,Pizza.crustType)
  def this(crustType:String)=this(Pizza.crustThickness,crustType)
  def this()=this(Pizza.crustThickness,Pizza.crustType)
}

object Pizza {
  val crustThickness=12
  val crustType="thin"
}
