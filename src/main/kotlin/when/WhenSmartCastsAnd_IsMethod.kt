package `when`

interface Expr
class Num(val value : Int) : Expr
class Sum(val left : Expr, val right : Expr) : Expr

fun eval(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
        else -> throw IllegalArgumentException("Unknown expr")
    }
//Kotlin’s is check provides some additional convenience: If you check the
//variable for a certain type, you don’t need to cast it afterward; you can use it
//as having the type you checked for. In effect, the compiler performs the cast
//for you: something we call a smart cast. (This is more ergonomic than in
//Java, where after checking the type of a variable, you still need to add an
//explicit cast.

fun evalWithLogging(e: Expr): Int =
    when (e) {
        is Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")
            left + right
        }
        else -> throw IllegalArgumentException("Unknown expression")
    }


fun main(){
    println(eval(Sum((Sum(Num(1),Num(2))),Num(4))))
    println(evalWithLogging(Sum((Sum(Num(1),Num(2))),Num(4))))
}