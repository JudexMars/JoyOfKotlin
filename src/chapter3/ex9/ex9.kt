package chapter3.ex9

//fun <A, B, C, D> func(a: A, b: B, c: C, d: D): String = "$a, $b, $c, $d"

fun <A, B, C, D> curried() = { a: A ->
    { b: B ->
        { c: C ->
            { d: D ->
                "$a, $b, $c, $d"
            }
        }
    }
}

fun main() {
    val curried = curried<String, String, String, String>()("a")("b")("c")("d")
    println(curried)
}