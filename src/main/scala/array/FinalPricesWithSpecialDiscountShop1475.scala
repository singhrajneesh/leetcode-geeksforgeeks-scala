object FinalPricesWithSpecialDiscountShop1475 {
    def finalPrices(prices: Array[Int]): Array[Int] = {
      val newArr=new Array[Int](prices.length)
      for(i <- 0 to prices.length-2)
      {
        if(prices(i)>=prices(i+1)) newArr(i)=prices(i)-prices(i+1)
        else
        {
          var j=i+1
          while(prices(i)<prices(j) && j<prices.length-1) j+=1
          if(j<prices.length && prices(i)>=prices(j) )
            newArr(i)=prices(i)-prices(j)
          else newArr(i)=prices(i)
        }
      }
      newArr(prices.length-1)=prices(prices.length-1)
      newArr
    }
}
