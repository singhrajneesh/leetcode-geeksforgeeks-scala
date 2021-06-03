package leetcode.array
import scala.collection.mutable._

object QueensThatCanAttackKing1222 {

    def queensAttacktheKing(queens: Array[Array[Int]], king: Array[Int]): List[List[Int]] = {
      val checkDiagonal = king(0) - king(1)
      var mapOfPosition = scala.collection.mutable.Map[String, List[Int]]()
      for (i <- 0 to queens.length - 1) {
        if (queens(i)(0) == king(0) && queens(i)(1) > king(1))
          insertInMap(mapOfPosition, queens, "right", ">", 1, i)
        else if (queens(i)(0) == king(0) && queens(i)(1) < king(1))
          insertInMap(mapOfPosition, queens, "left", "<", 1, i)
        else if (queens(i)(1) == king(1) && queens(i)(0) > king(0))
          insertInMap(mapOfPosition, queens, "down", ">", 0, i)
        else if (queens(i)(1) == king(1) && queens(i)(0) < king(0))
          insertInMap(mapOfPosition, queens, "up", "<", 0, i)
        else if (queens(i)(0) - queens(i)(1) == checkDiagonal) {
          if (queens(i)(0) > king(0))
            insertInMap(mapOfPosition, queens, "diagonalup", ">", 0, i)
          else
            insertInMap(mapOfPosition, queens, "diagonaldown", "<", 0, i)
        }
        else if (queens(i)(0) + queens(i)(1) == king(0) + king(1)) {
          if (queens(i)(0) < king(0) && queens(i)(1) > king(1)) {
            insertInMap(mapOfPosition, queens, "antidiagonalup", "<", 0, i)
          } else if (queens(i)(0) > king(0) && queens(i)(1) < king(1)) {
            insertInMap(mapOfPosition, queens, "antidiagonaldown", ">", 0, i)
          }

        }

      }
      mapOfPosition.values.toList
    }

    def insertInMap(mapOfPosition: Map[String, List[Int]], queens: Array[Array[Int]], side: String, operator: String, index: Int, i: Int): Unit = {
      var temp = mapOfPosition.getOrElse(side, Nil)
      temp match {
        case Nil => mapOfPosition += (side -> List(queens(i)(0), queens(i)(1)))
        case _ => {
          operator match {
            case "<" => if (temp(index) < queens(i)(index)) mapOfPosition += (side -> List(queens(i)(0), queens(i)(1)))
            case ">" => if (temp(index) > queens(i)(index)) mapOfPosition += (side -> List(queens(i)(0), queens(i)(1)))
          }
        }
      }
    }


}
