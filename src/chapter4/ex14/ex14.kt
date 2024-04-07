package chapter4.ex14

fun <T> unfold(seed: T, f: (T) -> T, p: (T) -> Boolean): List<T> {
    tailrec fun go(seed: T, acc: List<T>): List<T> {
        return if (!p(seed)) acc
        else go(f(seed), acc + seed)
    }
    return go(seed, mutableListOf())
}

fun main() {
    val unfolded = unfold(1, { it + 1}) { it < 10 }
    println(unfolded)
}