object Square extends App{
    def squareNumber(numberList: List[Int]): List[Int]={
        numberList.map(x=>x*x).filter(x=>x%2==0)
    }

    val nums=List(1,2,3,4,5,6,7,8,9,10)
    val squareList=squareNumber(nums)
    println(squareList)
}