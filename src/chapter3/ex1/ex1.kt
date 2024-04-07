package chapter3.ex1

fun main() {
    val composed = compose(::f, ::g)
    println(composed(1))
}

fun f(x: Int) = x * 2

fun g(x: Int) = x + 2

fun compose(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int {
    return { f(g(it)) }
}