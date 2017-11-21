package samples.algorithms

import samples.testing.util.TestUtil

/**
 * My implementations for merge sort and quick sort.
 * Note the implementations aren't probably the best.
 */
fun main(args: Array<String>) {

    checkSorting(arrayOf(1), arrayOf(1))
    checkSorting(arrayOf(1, 2), arrayOf(1, 2))
    checkSorting(arrayOf(2, 1), arrayOf(1, 2))
    checkSorting(arrayOf(2, 1, 3), arrayOf(1, 2, 3))
    checkSorting(arrayOf(1, 2, 3), arrayOf(1, 2, 3))
    checkSorting(arrayOf(3, 2, 1), arrayOf(1, 2, 3))
    checkSorting(
      arrayOf(1, 1, 1, 2, 3, 3, 2, 3, 1, 1),
      arrayOf(1, 1, 1, 1, 1, 2, 2, 3, 3, 3))
    checkSorting(
      arrayOf(1, 2, 3, 7, 4, 5, 6),
      arrayOf(1, 2, 3, 4, 5, 6, 7))
    checkSorting(
      arrayOf(11, 7, 17, 12, 5, 10, 4, 20, 21, 22, 3, 2, 38),
      arrayOf(2, 3, 4, 5, 7, 10, 11, 12, 17, 20, 21, 22, 38))

    println("All tests OK!")
}


/** Checks merge sort and quick sort */
fun checkSorting(original: Array<Int>, expectedSorted: Array<Int>) {
    checkMergeSort(original, expectedSorted)
    checkQuickSort(original, expectedSorted)
}

fun checkMergeSort(original: Array<Int>, expectedSorted: Array<Int>) {
    val sorted = mergeSort(original)
    TestUtil.assertEquals(sorted.toList(), expectedSorted.toList())
}

fun checkQuickSort(original: Array<Int>, expectedSorted: Array<Int>) {
    val copy = original.copyOf()
    quickSort(copy)
    TestUtil.assertEquals(copy.toList(), expectedSorted.toList())
}


// Quick sort

fun quickSort(a: Array<Int>) = quickSort(a, 0, a.size)

fun quickSort(a: Array<Int>, from: Int, to: Int) {

    val len = to - from

    if (len <= 1) return

    val p = partition(a, from, to)

    quickSort(a, from, p)
    quickSort(a, p, to)
}

/**
 * Returns a partition index p satisfying that,
 * for some value v:
 *   a(i) <= v  where i <= p
 *   a(i) >= v  where i >= p
 *
 * The value v is taken from the value in the middle of the array
 */
fun partition(a: Array<Int>, from: Int, to: Int): Int {

    val mid = from + (to - from)/2
    val v = a[mid]

    var p = from
    var q = to - 1

    while (p < q) {

        while (a[p] < v && p < q) p++
        while (a[q] > v && q > p) q--

        if (p < q) {
            val x = a[p]
            a[p] = a[q]
            a[q] = x
            p++
        }
    }

    return p
}


// Merge sort

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
