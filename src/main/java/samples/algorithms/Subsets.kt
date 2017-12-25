package samples.algorithms

fun main(args: Array<String>) {

    val numbers = listOf(1, 2, 5)
    printSubsets(numbers)
}

fun printSubsets(numbers: List<Int>) {
    printSubsets(emptyList(), numbers)
}

fun printSubsets(included: List<Int>, pending: List<Int>) {

    if (pending.isEmpty()) {
        println(included)
    } else {
        val rest = pending.drop(1)
        printSubsets(included.plus(pending[0]), rest)
        printSubsets(included, rest)
    }
}
