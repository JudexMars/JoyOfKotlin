package chapter3.ex3

val add: IntBinOp = { a -> { b -> a + b } }

typealias IntBinOp = (Int) -> (Int) -> Int

fun main() {
    println(add(1)(2))
}