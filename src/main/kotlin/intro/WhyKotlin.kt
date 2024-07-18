package intro

fun main(){
    val persons = listOf<Person>(
        Person("Alice", age = 29),
        Person("Bob"),
        Person("Andrey",23),
        Person("Maxtumquli",32)
    )
    val oldest = persons.maxBy {
        it.age ?: 0
    }
    println(oldest)
}

data class Person(
    val name : String,
    val age : Int? = null
)
//Our first Kotlin code snippet demonstrates how to create a collection in
//Kotlin, fill it with some Person objects, and then find the oldest person in the
//collection, using default values where no age is specified.
//When creating the list of people, it omits Bob’s age, so null is used as a
//default value. To find the oldest person in the list, the maxBy function is used.
//The lambda expression passed to the function takes one parameter, and it is
//used as the default name of that parameter. The Elvis operator (?:) returns
//zero if age is null. Because Bob’s age isn’t specified, the Elvis operator
//replaces it with zero, so Alice wins the prize for being the oldest person.