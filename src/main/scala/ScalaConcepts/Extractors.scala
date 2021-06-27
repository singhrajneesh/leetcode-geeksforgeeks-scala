package ScalaConcepts

// Scala program of extractors
// with pattern matching
// Creating object
object Extractors {


    // Main method
    def main(args: Array[String])
    {

      // Assigning value to the
      // object
     // val x = GfG(25)

      // Displays output of the
      // Apply method
     /* println(x)

      // Applying pattern matching
      x match
      {

        // unapply method is called
        case GfG(y) => println("The value is: "+y)
        case _ => println("Can't be evaluated")

      }*/
    }

    // Defining apply method
    def apply(x: Double) = x / 5

    // Defining unapply method
    def unapply(z: Double): Option[Double] =

      if (z % 5 == 0)
      {
        Some(z/5)
      }

      else None

}
