package interfaces

interface Clickable{
    fun click()
}

class Button : Clickable{
    override fun click() {
        println("Salom Sherbek")
    }
}
//using the override modifier is mandatory in Kotlin

interface ClickableDefaultParameter{
    fun click()
    fun showOff() = println("Salom Mahtumquli")
}

class ButtonDefaultParameter : ClickableDefaultParameter{
    override fun click() {
        println("Clicked")
    }

    override fun showOff() {
        println("Salom Sherbek")
    }
}
//If you implement this interface, you are forced to provide an implementation
//for click. You can redefine the behavior of the showOff method, or you can
//omit it if you’re fine with the default behavior.

fun main(){
    ButtonDefaultParameter().click()
    ButtonDefaultParameter().showOff()
}

