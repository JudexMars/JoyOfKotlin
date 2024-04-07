package chapter3.ex10

fun <A, B, C> curry(f: (A, B) -> C) = { a: A ->
    { b: B ->
        f(a, b)
    }
}

fun sum(a: Int, b: Int) = a + b

fun main() {
//    val f = curry { a: Int, b: Int -> a + b }
    val f = curry(::sum)
    println(f(1)(2))
}