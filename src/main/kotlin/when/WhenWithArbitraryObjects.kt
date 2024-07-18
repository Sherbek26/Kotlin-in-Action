package `when`
import `when`.Colors.*
import java.lang.Exception

fun mix(c1 : Colors, c2 : Colors) =
    when(setOf(c1,c2)){
        setOf(RED,YELLOW) -> ORANGE
        setOf(YELLOW,BLUE) -> GREEN
        setOf(BLUE,VIOLET) -> INDIGO
        else -> throw Exception("Dirty colors")
    }
//If colors c1 and c2 are RED and YELLOW (or vice versa), the result of mixing
//them is ORANGE, and so on. To implement this, you use set comparison. The
//Kotlin standard library contains a function setOf that creates a Set
//containing the objects specified as its arguments. A set is a collection for
//which the order of items doesn’t matter; two sets are equal if they contain the
//same items. Thus, if the sets setOf(c1, c2) and setOf(RED, YELLOW) are
//equal, it means either c1 is RED and c2 is YELLOW, or vice versa. This is
//exactly what you want to check.

fun mixOptimized(c1 : Colors, c2 : Colors) =
    when{
        (c1 == RED && c2 == YELLOW) ||
                (c1 == YELLOW && c2 == RED) ->
            ORANGE
        (c1 == YELLOW && c2 == BLUE) ||
                (c1 == BLUE && c2 == YELLOW) ->
            GREEN
        (c1 == BLUE && c2 == VIOLET) ||
                (c1 == VIOLET && c2 == BLUE) ->
            INDIGO
        else -> throw Exception("Dirty color")
    }
// You may have noticed above is somewhat inefficient. Every time you call
//this function, it creates several Set instances that are used only to check
//whether two given colors match the other two colors. Normally this isn’t an
//issue, but if the function is called often, it’s worth rewriting the code in a
//different way to avoid creating many short-lived objects which need to be
//cleaned up by the garbage collector. You can do it by using the when
//expression without an argument. The code is less readable, but that’s the
//price you often have to pay to achieve better performance.
// If no argument is supplied for the when expression, the branch condition is
//any Boolean expression. The mixOptimized function does the same thing as
//mix did earlier. Its advantage is that it doesn’t create any extra objects, but the
//cost is that it’s harder to read.

fun main(){
    println(mix(BLUE,GREEN))
}