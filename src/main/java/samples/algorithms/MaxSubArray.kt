package samples.algorithms

// Exercise maximum sub-array
// from book "Introduction to Algorithms"

fun main(args: Array<String>) {

    val list = listOf(13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7)

    val range = maxSubList(list)
    println(range)

    val subList = list.subList(range.from, range.to + 1)
    println(subList)

    Util.checkEquals(range, Range(7, 10, 43))
    Util.checkEquals(subList, listOf(18, 20, -7, 12))
}

data class Range<T>(var from:Int, var to:Int, var sum:T)

/**
 * Returns the Range of the sub-list whose sum is the maximum (maximum sub-array).
 * You can get the max sub-list with: list.subList(result.from, result.to+1)
 */
fun maxSubList(list: List<Int>): Range<Int> {

    var best = Range(from = 0, to = 0, sum = list[0])
    val current = best.copy()

    for (i in 1 until list.size) {

        current.sum += list[i]
        current.to = i

        if (current.sum > best.sum) {
            best = current.copy()
        } else if (current.sum <= 0) {
            current.from = i+1
            current.sum = 0
        }
    }

    return best
}
