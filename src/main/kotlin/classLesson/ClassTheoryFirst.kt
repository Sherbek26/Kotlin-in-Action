package classLesson
class Rectangle(val width : Int, val height : Int){
    val isSame : Boolean get() {
        return height == width
    }
}
fun main(){
    val name = readln()
    println("Hello ${name.ifBlank { "someone" }}")
}

