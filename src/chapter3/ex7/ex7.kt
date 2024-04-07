package chapter3.ex7

fun <A, B, C> partialA(a: A, f: (A) -> (B) -> C) = f(a)

fun main() {
    val f = { a: Int -> { b: Int -> a + b } }

    val g = partialA(1, f)(2)
    println(g)
}