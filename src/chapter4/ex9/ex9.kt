package chapter4.ex9

fun range(start: Int, end: Int): List<Int> {
    var i = start
    val list = mutableListOf<Int>()
    while (i < end) list.add(i++)
    return list
}

fun main() {
    println(range(0, 10))
}
