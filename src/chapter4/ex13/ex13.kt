package chapter4.ex13

import chapter4.ex8.prepend

fun <T> unfold(seed: T, f: (T) -> T, p: (T) -> Boolean): List<T> {
    return if (!p(seed)) listOf()
    else prepend(unfold(f(seed), f, p), seed)
}

fun main() {
    val unfolded = unfold(0, { it + 1 }) { it < 10 }
    println(unfolded)
}