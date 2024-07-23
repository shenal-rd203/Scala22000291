object Main{
    def volume(r:Double):Double={
        math.Pi*r*r*r*4/3
    }
    def main(args:Array[String]):Unit={
        println(f"${volume(5)}%.2f")
    }
}