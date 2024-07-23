object question {
    def main(args: Array[String]): Unit = {
        var k, i, j = 2
        var m, n = 5
        var f = 12.0f
        var g = 4.0f
        var c = 'X'
        var tmp: Any = null

        tmp = k + 12 * m
        println(tmp)

        tmp = m / j
        println(tmp)

        tmp = n % j
        println(tmp)

        tmp = m / j * j
        println(tmp)

        tmp = f + 10*5 + g
        println(tmp)

        // because scala does not have pre increment operators
        i += 1
        tmp = (i) * n
        println(tmp)
    }
}