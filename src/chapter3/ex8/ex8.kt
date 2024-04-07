package chapter3.ex8

fun <A, B, C> partialB(b: B, f: (A) -> (B) -> C) = { a: A ->
    f(a)(b)
}

fun main() {
    val f = { a: Int -> { b: Int -> a / b } }

    val g = partialB(2, f)(6)
    println(g)
}