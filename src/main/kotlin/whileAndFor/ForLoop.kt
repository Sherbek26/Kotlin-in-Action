package whileAndFor

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}
fun main() {
    for (i in 1..100) {
        print(fizzBuzz(i))
    }
// 1 2 Fizz 4 Buzz Fizz 7 ...

    for (i in 100 downTo 1 step 3) {
        print(fizzBuzz(i))
    }
// Buzz 98 Fizz 94 92 FizzBuzz 88 ...

//    Now you’re iterating over a progression that has a step, which allows it to
//skip some numbers. The step can also be negative, in which case the
//progression goes backward rather than forward. In this example, 100 downTo
//1 is a progression that goes backward (with step -1). Then step changes the
//absolute value of the step to 2 while keeping the direction (in effect, setting
//the step to -2).

    for (i in 100 downTo 1){
        print(fizzBuzz(i))
    }

    val binaryReps = mutableMapOf<Char,String>()
    for (char in 'A'..'F'){
        val binary = char.code.toString(radix = 2)
        binaryReps[char] = binary
    }
    for ((letter,binary) in binaryReps){
        println("$letter: $binary")
    }

    println()
    val list = listOf<Int>(10,11,12,13)
    for ((index,element) in list.withIndex()){
        println("$index: $element")
    }
//    You can use the same unpacking syntax to iterate over a collection while
//keeping track of the index of the current item. This lets you avoid creating a
//separate variable to store the index and incremeneting it by hand. In this case,
//you’re printing the elements of a collection with their respective index using
//the withIndex function

    fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
    fun isNotDigit(c: Char) = c !in '0'..'9'
    println(isLetter('q'))
// true
    println(isNotDigit('x'))
// true
//    This technique for checking whether a character is a letter looks simple.
//Under the hood, nothing tricky happens: you still check that the character’s
//code is somewhere between the code of the first letter and the code of the last
//one. But this logic is concisely hidden in the implementation of the range

    fun recognize(c: Char) = when (c) {
        in '0'..'9' -> "It's a digit!"
        in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
        else -> "I don't know..."
    }
//    using When

//    The same in check works with collections as well:
    fun main() {
        println("Kotlin" in setOf("Java", "Scala"))
// false
    }

}
