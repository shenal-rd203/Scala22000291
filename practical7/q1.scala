object filterEven extends App{
    def filterEven(numberList: List[Int]): List[Int]={
        numberList.filter(x=>x%2==0)
    }

    val nums=List(1,2,3,4,5,6,7,8,9,10)
    val evenNums=filterEven(nums)
    println(evenNums)
}