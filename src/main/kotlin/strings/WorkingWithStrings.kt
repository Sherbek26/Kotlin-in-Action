package strings

fun main() {
    println("12.345-6.A".split("-"))
// [12, 345, 6, A]

    val kotlinLogo =
        """
| //
|//
|/ \
""".trimIndent()
println(kotlinLogo)
//    multiline triple-quoted string

}

fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")
    println("Dir: $directory, name: $fileName, ext: $extension")
}
//The substring before the last slash symbol of the file path is the path to an
//enclosing directory, the substring after the last dot is a file extension, and the
//filename goes between them



//Kotlin makes it easier to work with strings without resorting to regular
//expressions, which are powerful but also sometimes hard to understand after
//they’ve been written. If you do want to use regular expressions, the Kotlin
//standard library can help. Here’s how the same task can be done using
//regular expressions:

fun parsePathRegex(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("Dir: $directory, name: $filename, ext: $extension")
    }
}
//In this example, the regular expression is written in a triple-quoted string. In
//such a string, you don’t need to escape any characters, including the
//backslash, so you can encode a regular expression matching a literal dot with
//\. rather than \\. as you’d write in an ordinary string literal. This regular expression divides a path into three groups separated by a slash
//and a dot. The pattern . matches any character from the beginning, so the
//first group (.+) contains the substring before the last slash. This substring
//includes all the previous slashes, because they match the pattern "any
//character". Similarly, the second group contains the substring before the last
//dot, and the third group contains the remaining par
