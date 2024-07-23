object InventoryManagementSystem {
  var itemNames: Array[String] = Array("Apple", "Banana", "Orange", "Milk", "Bread")
  var itemQuantities: Array[Int] = Array(50, 30, 40, 20, 25)

  def displayInventory(): Unit = {
    println("Current Inventory:")
    for (i <- itemNames.indices) {
      println(s"${itemNames(i)}: ${itemQuantities(i)}")
    }
    println()
  }

  def restockItem(itemName: String, quantity: Int): Unit = {
    val index = itemNames.indexOf(itemName)
    if (index != -1) {
      itemQuantities(index) += quantity
      println(s"Restocked $quantity ${itemName}(s). New quantity: ${itemQuantities(index)}")
    } else {
      println(s"Item '$itemName' not found in inventory.")
    }
  }

  def sellItem(itemName: String, quantity: Int): Unit = {
    val index = itemNames.indexOf(itemName)
    if (index != -1) {
      if (itemQuantities(index) >= quantity) {
        itemQuantities(index) -= quantity
        println(s"Sold $quantity ${itemName}(s). Remaining quantity: ${itemQuantities(index)}")
      } else {
        println(s"Not enough $itemName in stock. Current quantity: ${itemQuantities(index)}")
      }
    } else {
      println(s"Item '$itemName' not found in inventory.")
    }
  }

  def main(args: Array[String]): Unit = {
    println("Welcome to the Inventory Management System")
    displayInventory()

    restockItem("Apple", 10)
    restockItem("Grape", 15)
    displayInventory()

    sellItem("Banana", 5)
    sellItem("Milk", 25)
    sellItem("Orange", 50)
    displayInventory()
  }
}