package samples.algorithms

import samples.testing.util.TestUtil

fun main(args: Array<String>) {

    checkMergeSort(arrayOf(1), arrayOf(1))
    checkMergeSort(arrayOf(1, 2), arrayOf(1, 2))
    checkMergeSort(arrayOf(2, 1), arrayOf(1, 2))
    checkMergeSort(arrayOf(2, 1, 3), arrayOf(1, 2, 3))
    checkMergeSort(
      arrayOf(11, 7, 17, 12, 5, 10, 4, 20, 21, 22, 3, 2, 38),
      arrayOf(2, 3, 4, 5, 7, 10, 11, 12, 17, 20, 21, 22, 38))

    println("All tests OK!")
}


// Merge sort

fun checkMergeSort(original: Array<Int>, expectedSorted: Array<Int>) {
    val sorted = mergeSort(original)
    TestUtil.assertEquals(sorted.toList(), expectedSorted.toList())
}

fun mergeSort(a: Array<Int>):Array<Int> = mergeSort(a, 0, a.size)

fun mergeSort(a: Array<Int>, from: Int, to: Int):Array<Int> {

    val len = to - from

    if (len == 1) {

        return arrayOf(a[from])

    } else {

        // Split the array and sort (recursively)

        val mid = from + len/2

        val a1 = mergeSort(a, from, mid)
        val a2 = mergeSort(a, mid, to)

        // merge the 2 halves

        var a1i = 0
        var a2i = 0
        var bi = 0
        val b = Array(len, {0})

        while (a1i < a1.size || a2i < a2.size) {
            if (a2i == a2.size || (a1i < a1.size && a1[a1i] <= a2[a2i])) {
                b[bi++] = a1[a1i++]
            } else {
                b[bi++] = a2[a2i++]
            }
        }

        return b
    }
}
