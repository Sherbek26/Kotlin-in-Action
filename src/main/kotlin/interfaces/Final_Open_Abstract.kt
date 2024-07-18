package interfaces


open class RichButton : ClickableDefaultParameter {
    fun disable() {}
    open fun animate() {}
    override fun click() {}
}

class ThemedButton : RichButton() {
    override fun animate() {}
    override fun click() {}
    override fun showOff() {
        super.showOff()
    }
}

