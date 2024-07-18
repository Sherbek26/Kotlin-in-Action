package collections

fun main(){
    val list = listOf<Int>(1,2,3,4,5,6,6,7,7)
    println(list.joinToString(separator = ";", prefix = "(", postfix = ")"))

    val args = arrayOf(2, 3, 5, 7, 11)
    val list1 = listOf("args: ", *args)
        println(list1)

    val (number, name) = 1 to "one"

}