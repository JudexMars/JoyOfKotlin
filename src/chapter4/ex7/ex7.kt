package chapter4.ex7

import chapter4.ex5.foldLeft

fun <T> prepend(list: List<T>, elem: T) : List<T> = listOf(elem) + list

fun <T> reverse(list: List<T>) : List<T> = foldLeft(list, listOf(), ::prepend)

fun main() {
    val list = (1..10).toList()
    val reversed = reverse(list)
    println(reversed)
}