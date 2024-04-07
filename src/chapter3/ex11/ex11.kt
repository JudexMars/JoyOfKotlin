package chapter3.ex11

val addTax: (Double) -> (Double) -> Double = { x ->
    { y ->
        x + x / 100 * y
    }
}

fun <A, B, C> swap(f: (A) -> (B) -> (C)) = { b: B ->
    { a: A ->
        f(a)(b)
    }
}

fun main() {
    println(addTax(10.0)(15.0))
    println(swap(addTax)(15.0)(10.0))
}