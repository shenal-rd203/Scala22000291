import scala.io.StdIn.readLine

object Inventory{
  def getProductList: List[String]={
    var products=List[String]()
    var input=""
    println("Enter product names('done' for finish):")
    while({input=readLine(); input!="done"}){
      products=products:+input
    }
    products
  }

  def printProductList(products:List[String]):Unit={
    printf("\n")
    products.foreach(println)
  }

  def getTotalProducts(product:List[String]):Int={
    product.length
  }

  def main(args:Array[String]):Unit={
    val productList=getProductList
    printProductList(productList)
    println(s"Total products:${getTotalProducts(productList)}")
  }
}