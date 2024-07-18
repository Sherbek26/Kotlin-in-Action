package sealed

sealed interface Shape

data class Circle(val radius: Double) : Shape
data class Square(val side: Double) : Shape
