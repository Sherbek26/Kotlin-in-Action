package `when`

fun getMnemonic(color: Colors) =
    when(color){
        Colors.RED -> "Richard"
        Colors.ORANGE -> "Of"
        Colors.YELLOW -> "York"
        Colors.GREEN -> "Gave"
        Colors.BLUE -> "Battle"
        Colors.INDIGO -> "In"
        Colors.VIOLET -> "Vain"
    }


fun main(){
    println(getMnemonic(Colors.GREEN))
}