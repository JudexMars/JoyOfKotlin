package chapter4.ex12

import chapter4.ex8.prepend

fun range(start: Int, end: Int): List<Int> {
    if (end <= start) return listOf()
    else return prepend(range(start + 1, end), start)
}

fun main() {
    val result = range(0, 10)
    println("Result: $result")
}