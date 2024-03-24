package spark

object FoldLeftAndReduce extends App {

  val listOfListsElementwise = List(1,2,3)

  println(listOfListsElementwise.foldRight(2)(_-_))


  println(listOfListsElementwise.foldLeft(2)(_-_))


  println(listOfListsElementwise.fold(2)(_-_))

  //fold = foldleft

  println(listOfListsElementwise.reduce(_+_))



}

