package chapter4.ex3

import java.math.BigInteger

fun fibonacci(number: Int): Int =
    if (number == 0 || number == 1)
        1
    else
        fibonacci(number - 1) + fibonacci(number - 2)

/**
 * Corecursive version of this algorithm is immensely more efficient
 * because of the use of TLE. It also is patched against Arithmetical overflow errors
 */
fun fibonacciCorecursive(number: BigInteger): BigInteger {
    var i = BigInteger.TWO
    tailrec fun go(a: BigInteger, b: BigInteger): BigInteger {
        if (i != number) {
            i++
            return go(b, a + b)
        } else return a + b
    }
    return if (number == BigInteger.ZERO || number == BigInteger.ONE) BigInteger.ONE
    else go(BigInteger.ONE, BigInteger.ONE)
}

fun fibonacciCorecursive2(number: BigInteger): BigInteger {
    tailrec fun go(a: BigInteger, b: BigInteger, x: BigInteger): BigInteger =
        when {
            (x == BigInteger.ZERO) -> BigInteger.ONE
            (x == BigInteger.ONE) -> a + b
            else -> go(b, a + b, x - BigInteger.ONE)
        }
    return go(BigInteger.ZERO, BigInteger.ONE, number)
}

fun main() {
    println("Fibonacci recursive function result:")
    (0..<10).forEach { print("${fibonacci(it)} ") }
    println("\nFibonacci corecursive function result:")
    (0L..<10L).forEach { print("${fibonacciCorecursive(BigInteger.valueOf(it))} ") }
    println("\nFibonacci corecursive function 2 result:")
    (0L..<10L).forEach { print("${fibonacciCorecursive2(BigInteger.valueOf(it))} ") }
}
