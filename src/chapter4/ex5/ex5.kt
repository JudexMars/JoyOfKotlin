package chapter4.ex5

import chapter4.ex4.head
import chapter4.ex4.tail

fun <T, U> foldLeft(list: List<T>, x: U, f: (U, T) -> U): U {
    tailrec fun go(list: List<T>, result: U): U =
        when {
            list.isEmpty() -> result
            else -> go(list.tail(), f(result, list.head()))
        }
    return go(list, x)
}

fun <T> makeString(list: List<T>, delim: String): String =
    foldLeft(list, "") { s, t ->
        if (list.isEmpty()) "$t" else "$s$delim$t"
    }

fun string(list: List<Char>): String = foldLeft(list, "", String::plus)

fun sum(list: List<Int>): Int = foldLeft(list, 0, Int::plus)

fun main() {
    val list = listOf(1, 2, 3, 4, 5)
    val delim = " "
    val resultString = makeString(list, delim)
    println(resultString)

    val resultSum = sum(list)
    println(resultSum)

    val chars = listOf('a', 'b', 'c')
    val resultString2 = string(chars)
    println(resultString2)
}