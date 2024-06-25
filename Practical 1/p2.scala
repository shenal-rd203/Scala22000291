object Main{
    def converter(cel:Double):Double={
        cel*1.8+32
    }
    def main(args:Array[String]):Unit={
        println(converter(34))
    }
}