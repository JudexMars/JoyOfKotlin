package chapter4.ex8

import chapter4.ex5.foldLeft

//fun <T> copy(list: List<T>): List<T> = foldLeft(list, listOf()) { l, e -> l + e }

fun <T> prepend(list: List<T>, elem: T) : List<T> = foldLeft(list, listOf(elem)) { l, e -> l + e }

fun <T> reverse(list: List<T>) : List<T> = foldLeft(list, listOf(), ::prepend)

fun main() {
    val list = (1..10).toList()
    val reversed = reverse(list)
    println(reversed)
}