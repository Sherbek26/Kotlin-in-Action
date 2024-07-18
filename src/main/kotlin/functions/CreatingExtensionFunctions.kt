package functions

fun <T> Collection<T>.joinToString(
separator: String = ", ",
prefix: String = "",
postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}
//You make it an extension to a collection of elements, and you provide default
//values for all the arguments. Now you can invoke joinToString like a
//member of a class:

fun Collection<String>.join(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) = joinToString(separator, prefix, postfix)
//Because extension functions are effectively syntactic sugar over static
//method calls, you can use a more specific type as a receiver type, not only a
//class. Let’s say you want to have a join function that can be invoked only on
//collections of strings.

fun main() {
    val list = listOf(1, 2, 3)
    println(
        list.joinToString(
            separator = "; ",
            prefix = "(",
            postfix = ")"
        )
    )
// (1; 2; 3)
    val listStrings = listOf<String>("Salom","Xayr","Hayvon","Olmaxon")
    println(listStrings.join(";","["))
}

