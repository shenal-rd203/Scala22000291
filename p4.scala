object Main{
    def discountedPrice(price: Double): Double={
        price*0.6
    }
    def shippingCost(books: Int): Double={
        if(books<=50){
            books*3
        }else{
            50*3+(books-50)*0.75
        }
    }
    def wholesalePrice(books: Int, bookPrice: Double): Double={
        discountedPrice(bookPrice)*books+shippingCost(books)
    }

    def main(args:Array[String]):Unit={
        println(f"${wholesalePrice(60,24.95)}%.2f")
    }
}