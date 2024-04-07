package chapter4.ex10

fun <T> unfold(seed: T, f: (T) -> T, p: (T) -> Boolean): List<T> {
    val list = mutableListOf<T>()
    var elem = seed
    while (p(elem)) {
        list.add(elem)
        elem = f(elem)
    }
    return list
}

fun main() {
    val unfolded = unfold(1, { it + 1 }) { it < 10 }
    println(unfolded)
}