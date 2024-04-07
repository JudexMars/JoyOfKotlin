package chapter4.ex1

fun append(s: String, c: Char): String = "$s$c"

// Tail Call Elimination (TLE) is allowed here because
// the corecursive call is the last operation of the function
tailrec fun toStringCorecursive(list: List<Char>, s: String = ""): String =
    if (list.isEmpty())
        s
    else
        toStringCorecursive(list.drop(1), append(s, list.first()))

fun prepend(c: Char, s: String): String = "$c$s"

// True recursive functions are not recommended for use if
// there is a corecursive alternative in mind, because
// they use more stack space than the corecursive version
// and cannot be optimized with TLE
fun toStringRecursive(list: List<Char>): String =
    if (list.isEmpty())
        ""
    else
        prepend(list.first(), toStringRecursive(list.drop(1)))

fun main() {
    val s1 = toStringCorecursive(listOf('a', 'b', 'c'))
    println(s1)

    val s2 = toStringRecursive(listOf('a', 'b', 'c'))
    println(s2)

    val n = 4
    println(sum(n))
    println(sumCorecursive(n))

    val a = 4
    val b = 16
    val addition = add(a, b)
    println(addition)
}

fun sum(n: Int): Int {
    fun sum(sum: Int, idx: Int): Int =
        if (idx < 1)
            sum
        else
            sum(sum + idx, idx - 1)
    return sum(0, n)
}

fun sumCorecursive(n: Int): Int {
    tailrec fun sumLoop(sum: Int, i: Int): Int =
        if (i < 1) sum else sumLoop(sum + i, i - 1)
    return sumLoop(0, n)
}

fun inc(n: Int) = n + 1
fun dec(n: Int) = n - 1

tailrec fun add(a: Int, b: Int): Int {
    if (a == 0) return b
    else if (b == 0) return a
    return add(inc(a), dec(b))
}

//fun add(a: Int, b: Int): Int =
//    if (a == 0) b
//    else if (b == 0) a
//    else add(inc(a), dec(b))
