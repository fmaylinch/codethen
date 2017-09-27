package samples.kotlin

import samples.classes.Car
import java.util.*

/**
 * A Kotlin file might contain functions and classes.
 * Functions don't need to be inside a class.
 *
 * Anyway, we should organize our code. :)
 */

/**
 * This is like the main() in Java applications, so this Kotlin
 * file can be run as any Java class with a main.
 */
fun main(args: Array<String>) {


    // --- Basics ---

    // No semicolon `;` needed
    println("Hello world")  // Java: System.out.println("Hello world");

    val a : Int = 3
    val b = 4 // b type is inferred (implicit); it's an Int

    val c = sum(a, b) // c type is also inferred to be Int
    println("Sum: " + c)


    var age = 20 // Java: int age = 20;
    age = 25
    val name = "Peter" // Java: final String name = "Peter";


    val message = "$name is $age years old" // String interpolation
    println(message)

    val temperature = 30
    println("temp is ${temperature}Cº") // use curly braces when needed


    // --- Optionals ---

    var amount : Int? = null // optional value; may be null

    if (Random().nextBoolean()) {
        amount = 10 // we assign 10 sometimes
    }

    println("amount: $amount")

    // if-expression (in Java we use c?v1:v2)
    // Java: final int a2 = (amount != null) ? amount * 2 : 0;
    val a2 = if (amount != null) amount * 2 else 0
    println("a2: $a2")

    // Java: final int a3 = (amount != null) ? amount : 0;
    val a3 = amount ?: 0 // elvis operator to specify a default value
    println("a3: $a3")

    try {
        val a4 = amount!! + 1 // caution, will crash if `amount` is null
        println("a4: $a4")
    } catch (e: Exception) {
        println("Amount was null so we couldn't get its value with the !! operator")
    }


    // --- Classes ---

    val person1 = KotlinPerson("Peter", 20) // in Kotlin we don't put `new`
    // person1.age = -5  // This value is wrong and would throw an exception in the setter
    person1.lastName = "Smith"
    println("${person1.full()} is ${person1.age}")

    // Simple class
    val product1 = Product("tv", 500)
    product1.price += 10

    // Using a Java class from Kotlin
    val car1 = Car("Ford")
    car1.speed = 100 // we're using the setter here!


    // --- Collections ---

    val array1 = arrayOf(1, 2, 3, 4, 5) // Java: int[] array1 = {1, 2, 3, 4, 5};
    val list1 = listOf(1, 2, 3, 4, 5) // Java: List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5)
    val set1 = setOf(1, 2, 3, 4, 5)
    val map1 = mapOf("peter" to 7.5, "mary" to 8.5) // Java: map1.put("peter", 7.5) etc

    // Those collections are immutable (can't be modified)
    // but you can get a mutable copy
    val mutableList1 = list1.toMutableList()
    mutableList1.add(6)

    // Or create an ArrayList like in Java
    val list2 = ArrayList<Int>()
    list2.add(1)
    list2.add(2)
    list2.add(3)

    // Elements can be accessed with get(pos) or [pos], it's the same
    println("First element: ${list1[0]} == ${list1.get(0)}")
    println("Peter points: ${map1["peter"]} == ${map1.get("peter")}")

    // Easy use of map, filter, reduce and other handy methods (sum, max, etc)
    val result = list1.map { x -> x * 10 }.filter { x -> x > 25 }.sum()
    println(result)

    // Handy method for joining a collection into a string
    println( array1.joinToString("; ") )


    // --- Loops / Ranges ---

    // Java: for (int x : array1)
    for (x in array1) {
        print(x)
    }
    
    println()

    // Java: for (int x = 1; i <= y; i++)
    val y = 5
    for (x in 1..y) { // 1..y is a range
        print(x)
    }

    println()

    // Usual while loops too
    var z = 0
    while (z < 5) {
        print(z)
        z++
    }

    println()

    // Using ranges with filter (or map, or reduce, etc)
    val evens = (1..20).filter { x -> x % 2 == 0 }
    println("Evens: $evens")
}


// Java: int sum(int x, int y)
fun sum(x:Int, y:Int):Int {
    return x + y
}

// Same as before, shorter version
fun sum2(x:Int, y:Int) = x + y


class KotlinPerson (n: String, age: Int) { // constructor parameters are here!

    // Properties

    val name: String = n // Java: this.name = n;

    var lastName: String? = null

    var age: Int = age
        // We can intercept when the value is set (like a setter in Java)
        set(value) {
            if (value < 0) {
                throw RuntimeException("age can't be negative!")
            }
        }

    // Method
    fun fullName() : String {
        return if (lastName == null) name else "$name $lastName"
    }

    // Shorter version
    fun full() = if (lastName == null) name else "$name $lastName"
}


/**
 * Simple class with 2 fields, one final and the other not final.
 * `name` and `price` are both constructor parameters AND fields.
 *
 * In Java we would:
 * - Define the fields
 * - Implement the constructor
 * - Implement getters and setters
 *
 * In Kotlin, we have those 3 things with one line
 */
class Product(val name: String, var price: Int) {

    // `override` keyword is mandatory (not like optional @Override annotation)
    override fun toString() = "$name: $price"
}
