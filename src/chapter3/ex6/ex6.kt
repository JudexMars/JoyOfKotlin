package chapter3.ex6

val square: (Int) -> Int = { it * 2 }
val triple: (Int) -> Int = { it + 3 }

fun <T, U, V> composeReverse(): ((T) -> U) -> ((V) -> T) -> (V) -> U = { x -> { y -> { z -> x(y(z)) } } }

fun main() {
    val result = composeReverse<Int, Int, Int>()(triple)(square)(1)
    println(result)
}