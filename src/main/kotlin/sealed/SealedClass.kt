package sealed

import java.time.LocalDateTime

sealed class Expr
class Num(val value : Int) : Expr()
class Sum(val left : Expr, val right : Expr) : Expr()
class Mul(val first : Expr, val second : Expr) : Expr()

//Kotlin comes with a solution to this problem: sealed classes. You mark a
//superclass with the sealed modifier, and that restricts the possibility of
//creating subclasses. All direct subclasses of a sealed class must be known at
//compile time and declared in the same package as the sealed class itself, and
//all subclasses need to be located within the same module.


fun describeShape(shape: Shape): String = when (shape) {
    is Circle -> "A circle with radius ${shape.radius}"
    is Square -> "A square with side ${shape.side}"
    // No need for an else branch because Shape is sealed
    else -> {""}
}

fun main() {
    val shapes = listOf<Shape>(Circle(3.0), Square(4.0))
    shapes.forEach { shape ->
        println(describeShape(shape))
    }
    val date = LocalDateTime.now()
    println(date)

    val arrayList = arrayOf("Submit","Asallom")
    arrayList.sortedArray()
    println(arrayList.toList().toString())

}

data class Triangle(val base : Double, val height : Double) : Shape



