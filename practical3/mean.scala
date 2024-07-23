object Mean{
    def findMean(num1: Int, num2: Int): Double = {
        val mean = (num1.toDouble + num2)/2
        val roundedScaledMean = (mean*100 + 0.5).toLong
        roundedScaledMean.toDouble / 100
    }

    def main(args: Array[String]):Unit={
        val input1=scala.io.StdIn.readLine("Enter first number: ").toInt
        val input2=scala.io.StdIn.readLine("Enter second number: ").toInt
        println("Mean in float: "+findMean(input1, input2))
    }
}