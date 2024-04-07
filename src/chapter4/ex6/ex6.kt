package chapter4.ex6

import chapter4.ex1.prepend
import chapter4.ex4.head
import chapter4.ex4.tail

fun <T, U> foldRight(list: List<T>, identity: U, f: (T, U) -> U): U =
    if (list.isEmpty()) identity
    else f(list.head(), foldRight(list.tail(), identity, f))

fun string(list: List<Char>): String = foldRight(list, "") { char, string ->
    prepend(char, string)
}

fun main() {
    val list = listOf('a', 'b', 'c')
    val result = string(list)
    println("Result: $result")
}