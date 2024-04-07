package chapter4.ex4

fun <T> List<T>.tail(): List<T> =
    if (this.isEmpty())
        throw IllegalArgumentException("tail called on empty list")
    else
        this.drop(1)

fun <T> List<T>.head(): T =
    if (this.isEmpty())
        throw IllegalArgumentException("head called on empty list")
    else
        this[0]


fun <T> makeString(list: List<T>, delim: String): String =
    when {
        list.isEmpty() -> ""
        list.tail().isEmpty() ->
            "${list.head()}${makeString(list.tail(), delim)}"

        else -> "${list.head()}$delim${makeString(list.tail(), delim)}"
    }

fun <T> makeStringCorecursive(list: List<T>, delim: String): String {
    tailrec fun go(list: List<T>, result: String): String =
        when {
            list.isEmpty() -> result
            result.isEmpty() -> go(list.tail(), "${list.head()}")
            else -> go(list.tail(), "$result$delim${list.head()}")
        }
    return go(list, "")
}

fun main() {
    val list = listOf(1, 2, 3, 4, 5)
    val delim = " "
    val string = makeStringCorecursive(list, delim)
    println("Result: $string")
}