object Prime extends App{
    def filterPrime(numList: List[Int]): List[Int]={
        def isPrime(n: Int): Boolean={
            if (n<=1) false
            else if (n==2) true
            else !(2 to Math.sqrt(n).toInt).exists(x=>n%x==0)
        }
        numList.filter(x=>isPrime(x))
    }
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
    val primes = filterPrime(numbers)
    println(primes)
}