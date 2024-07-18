package localFunctions_Extensions

class User(val id: Int, val name: String, val address: String)
fun saveUser(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException(
            "Can't save user ${user.id}: empty Name")
    }
    if (user.address.isEmpty()) {
        throw IllegalArgumentException(
            "Can't save user ${user.id}: empty Address")
    }
// Save user to the database
}
//The amount of duplicated code here is fairly small, and you probably won’t
//want to have a full-blown method in your class that handles one special case
//of validating a user. But if you put the validation code into a local function,
//you can get rid of the duplication and still maintain a clear code structure.

fun saveUserLocalFunction(user: User) {
    fun validate(user: User,
    value: String,
    fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user ${user.id}: empty $fieldName")
        }
    }
    validate(user, user.name, "Name")
    validate(user, user.address, "Address")
// Save user to the database
}
//This looks better. The validation logic isn’t duplicated, but it’s still confined
//to the scope of the validate function.As the project evolves, you can easily
//add more validations if you need to add other fields to User. But having to
//pass the User object to the validation function is somewhat ugly. The good
//news is that it’s entirely unnecessary, because local functions have access to
//all parameters and variables of the enclosing function.

fun saveUserSimpleLocalFunction(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user ${user.id}: " +
                "empty $fieldName")
        }
    }
    validate(user.name, "Name")
    validate(user.address, "Address")
// Save user to the database
}
//To improve this example even further, you can move the validation logic into
//an extension function of the User class.
fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user $id: empty $fieldName")
        }
    }
    validate(name, "Name")
    validate(address, "Address")
}
fun saveUserValidateBeforeSave(user: User) {
    user.validateBeforeSave()
// Save user to the database
}
//Extracting a piece of code into an extension function turns out to be
//surprisingly useful. Even though User is a part of your codebase and not a
//library class, you don’t want to put this logic into a method of User, because
//it’s not relevant to any other places where User is used. If you follow this
//approach the API of the class contains only the essential methods used
//everywhere, so the class remains small and easy to wrap your head around.
//On the other hand, functions that primarily deal with a single object and don’t
//need access to its private data can access its members without extra
//qualification.Extension functions can also be declared as local functions, so you could go
//even further and put User.validateBeforeSave as a local function in
//saveUser. But deeply nested local functions are usually fairly hard to read;
//so, as a general rule, we don’t recommend using more than one level of
//nesting.

fun main() {
    saveUser(User(1, "", ""))
// java.lang.IllegalArgumentException: Can't save user 1: empty Name
}