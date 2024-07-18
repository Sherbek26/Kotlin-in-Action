package whileAndFor

fun main(){
    outer@ while (true) {
        while (true) {
            if (false) continue
            if (true) break@outer
            if (false) continue@outer
            if (true) break
        }
// ...For nested loops, Kotlin allows you to specify a label, which you can then
//reference when using break or continue. A label is an identifier followed by
//the @ sign:
    }
}