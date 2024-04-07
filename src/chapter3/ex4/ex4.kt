package chapter3.ex4

val square: IntUnaryOp = { it * 2 }
val triple: IntUnaryOp = { it + 3 }

typealias IntUnaryOp = (Int) -> Int

val compose: (IntUnaryOp) -> (IntUnaryOp) -> IntUnaryOp = { x -> { y -> { z -> x(y(z)) } } }

fun main() {
    val result = compose(square)(triple)(1)
    println(result)
}