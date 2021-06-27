package ScalaConcepts

object DiamondProblem extends App {
 // A Diamond Problem is Multiple Inheritance problems. Some people call this problem as Deadly Diamond Problem.
 // In Scala, it occurs when a Class extends more than one Traits which have same method definition.
 // Unlike Java 8, Scala solves this diamond problem automatically by following some rules defined in Language.
 // Those rules are called “Class Linearization”.

  trait A{
    def display(){ println("From A.display")  }
  }
  trait B extends A{
    override def display() { println("From B.display") }
  }
  trait C extends A{
    override def display() { println("From C.display") }
  }
  class D extends B with C{ }
  class E extends C with B{ }
    val d = new D
    d display()
    val e=new E
    e display()

  //Here the output is “From C.display” form trait C. Scala Compiler reads “extends B with C”
  // from right to left and takes “display” method definition from left most trait that is C
}
