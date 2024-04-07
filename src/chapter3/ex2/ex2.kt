package chapter3.ex2

fun main() {
    val composed = compose(::f, ::g)
    println(composed("HELLO"))

    val x = TestClass(name = "John", age = 30)
    println(x)
}

fun f(x: String) = x.repeat(5)

fun g(x: String) = x + 2

fun <T, U, V> compose(f: (T) -> U, g: (V) -> T): (V) -> U {
    return { f(g(it)) }
}

data class TestClass(
    val name: String = "Bob",
    val age: Int = 10
) {
    constructor(name: String = "Bob", age: Int = 10, test: String = "TEST") : this(name, age) {
        println(test)
    }
}