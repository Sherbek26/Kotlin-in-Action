package `when`
import `when`.Colors.*

fun measureColor() = YELLOW

fun getWarmthFromSensor() : String{
    val color = measureColor()
    return when(color){
        Colors.RED, Colors.ORANGE, Colors.YELLOW -> "warm (red = ${color.r})"
        Colors.GREEN -> "neutral (green = ${color.g})"
        Colors.BLUE, Colors.INDIGO, Colors.VIOLET -> "cold (blue = ${color.b})"
    }
}

fun getWarmthFromSensor2(): String {
    val color = measureColor()
    return when (color) {
        RED, ORANGE, YELLOW ->
            "warm (red = ${color.r})"
        GREEN ->
            "neutral (green = ${color.g})"
        BLUE, INDIGO, VIOLET ->
            "cold (blue = ${color.b})"
    }
}

fun main(){
    println(getWarmthFromSensor())
}