object InventorySystem {

  case class Product(id: Int, name: String, quantity: Int, price: Double)

  val inventory1: Map[Int, Product] = Map(
    101 -> Product(101, "ProductA", 10, 15.0),
    102 -> Product(102, "ProductB", 5, 25.0),
    103 -> Product(103, "ProductC", 20, 10.0)
  )

  val inventory2: Map[Int, Product] = Map(
    102 -> Product(102, "ProductB", 10, 20.0),
    104 -> Product(104, "ProductD", 15, 30.0)
  )

  def getProductNames(inventory: Map[Int, Product]): List[String] = {
    inventory.values.map(_.name).toList
  }

  def calculateTotalValue(inventory: Map[Int, Product]): Double = {
    inventory.values.map(product => product.quantity * product.price).sum
  }

  def isInventoryEmpty(inventory: Map[Int, Product]): Boolean = {
    inventory.isEmpty
  }

  def mergeInventories(inventory1: Map[Int, Product], inventory2: Map[Int, Product]): Map[Int, Product] = {
    inventory2.foldLeft(inventory1) { case (acc, (id, product2)) =>
      acc.get(id) match {
        case Some(product1) =>
          acc.updated(id, product1.copy(
            quantity = product1.quantity + product2.quantity,
            price = math.max(product1.price, product2.price)
          ))
        case None =>
          acc + (id -> product2)
      }
    }
  }

  def checkProductExists(inventory: Map[Int, Product], productId: Int): Unit = {
    inventory.get(productId) match {
      case Some(product) => println(s"Product found: $product")
      case None => println(s"Product with ID $productId not found.")
    }
  }

  def main(args: Array[String]): Unit = {
    println("Product Names: " + getProductNames(inventory1))
    println("Total Value: " + calculateTotalValue(inventory1))
    println("Is Inventory Empty: " + isInventoryEmpty(inventory1))
    val mergedInventory = mergeInventories(inventory1, inventory2)
    println("Merged Inventory: " + mergedInventory)
    checkProductExists(inventory1, 102)
  }
}