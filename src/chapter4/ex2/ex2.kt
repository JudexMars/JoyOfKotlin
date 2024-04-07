package chapter4.ex2

// Original recursive factorial fun function
//fun factorial(n: Int): Int = if (n == 0) 1 else n * factorial(n - 1)

// Recursive factorial value function
val factorial: (Int) -> Int by lazy {
    {
        if (it <= 0) 1 else it * factorial(it - 1)
    }
}

fun main() {
    println(factorial(0))
}