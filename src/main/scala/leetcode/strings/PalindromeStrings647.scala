package leetcode.strings

import scala.util.control.Breaks.{break, breakable}

object PalindromeStrings647 {

  def main(args: Array[String]): Unit = {
    var carry = 0
    var n:Char = '4'
    var num:Char = '1'
    var temp: Int = ((n.toInt)*(num.toInt))+carry

    getPalindromeStringOn3("aba")
  }

  def getPalindromeStringOn3(s :String): Int = {
    val resultMap = scala.collection.mutable.HashMap[String, Int]()
    for((key,value)<-resultMap){

    }
    for(element <- 0 until s.length) {
      resultMap += ( s(element).toString -> (resultMap.getOrElse(s(element).toString, 0) + 1))
      for(ele <- element+1 until s.length) {
        var start = element
        var end = ele
        var palin: String = s(start).toString
        breakable {
          while(start <= end) {
            if(s(start) != s(end))
              break
            palin = palin + s(start)
            start+=1
            end-=1
          }
        }
        if(start > end)
          resultMap+= (palin -> (resultMap.getOrElse(palin, 0) + 1))
      }
    }
    resultMap.values.sum
  }


  def countSubstringsOn2(s: String): Int = {
    var resultMap = 0
    for(element <- 0 until s.length) {
      var right = element
      var left = element
      while(left >= 0 && right <= s.length-1 && s(right) == s(left))
      {
        resultMap+=1
        right+=1
        left-=1
      }

      right = element+1
      left = element
      while(left >= 0 && right <= s.length-1 && s(right) == s(left))
      {
        resultMap+=1
        right+=1
        left-=1
      }
    }
    resultMap
  }
}


