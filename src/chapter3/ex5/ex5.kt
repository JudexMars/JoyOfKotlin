package chapter3.ex5

val square: (Int) -> Int = { it * 2 }
val triple: (Int) -> Int = { it + 3 }

fun <T, U, V> compose(): ((T) -> U) -> ((U) -> V) -> (T) -> V = { x -> { y -> { z -> y(x(z)) } } }

fun main() {
    val result = compose<Int, Int, Int>()(square)(triple)(1)
    println(result)
}