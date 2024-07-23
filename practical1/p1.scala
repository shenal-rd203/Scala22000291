object Main{
  def calculateDiskArea(r:Double):Double={
    math.Pi*r*r
  }
  def main(args:Array[String]):Unit={
    val area=calculateDiskArea(5)
    println(area)
  }
}