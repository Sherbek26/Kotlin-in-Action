package exceptionHandiling

import java.io.BufferedReader
import java.io.StringReader
import java.nio.Buffer

fun main(){
    val percentage =
        if (99 in 0..100)
            101
        else
            throw IllegalArgumentException(
                "A percentage value must be between 0 and 100: 101"
            )
    println(percentage)

    val reader = BufferedReader(StringReader("not a number"))
    readNumberTryAsExpression(reader)
}

fun readNumber(reader : BufferedReader) : Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    }catch (e : NumberFormatException){
        return  null
    }finally {
        reader.close()
    }
}

fun readNumberTryAsExpression(reader: BufferedReader){
    val number = try {
        Integer.parseInt(reader.readLine())
    }catch (e : NumberFormatException){
        return
    }
    println(number)
}