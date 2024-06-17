object Main{
    def easy(distance:Double):Double={
        distance*8
    }
    def tempo(distance:Double):Double={
        distance*7
    }
    def main(args:Array[String]):Unit={
        val runTime=easy(2)+tempo(3)+easy(2)
        println(s"$runTime Minutes")
    }
}