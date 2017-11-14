package samples.algorithms

// 0: 2           2
// 1: 3        /     \
// 2: 5       3       5
// 3: 9     /   \    /
// 4: 8    9    8   7
// 5: 7

//             0
//         /       \
//       1          2
//     /   \      /   \
//    3     4    5     6
//   / \
//  7   8

//   parent(idx) = (idx+1)/2 - 1

fun main(args: Array<String>) {

    val heap = Heap<Int>()
    heap.add(8)
    heap.add(2)
    heap.add(5)
    heap.add(9)
    heap.add(3)

    println(heap)

    while (!heap.isEmpty()) {
        println(heap.takeFirst())
    }
}

class Heap<T:Comparable<T>> {

    private val list = ArrayList<T>()

    override fun toString(): String {
        return list.toString()
    }

    fun add(x: T) {
        list.add(x)
        bubbleUp(list.size - 1)
    }

    fun first():T? = if (isEmpty()) null else list.first()

    fun isEmpty() = list.isEmpty()

    fun takeFirst():T? {
        val result = first()
        removeFirst()
        return result
    }

    fun removeFirst() {
        list[0] = list[list.size - 1]
        list.removeAt(list.size - 1)
        bubbleDown(0)
    }

    /**
    /** Bubbles down the element at the index, so the heap reminds sorted */
     */
    private fun bubbleDown(idx: Int) {

        val left = leftChildIndex(idx)
        val right = left + 1

        // select min child (min-heap) if there's any

        var minIdx = idx

        if (left < list.size && list[left] < list[minIdx]) {
            minIdx = left
        }

        if (right < list.size && list[right] < list[minIdx]) {
            minIdx = right
        }

        if (minIdx != idx) {
            swap(idx, minIdx)
            bubbleDown(minIdx)
        }
    }

    /** Bubbles up the element at the index, so the heap reminds sorted */
    private fun bubbleUp(idx: Int) {

        if (idx == 0) return

        val parentIdx = parentIndex(idx)

        // TODO: min-heap for now
        if (list[parentIdx] > list[idx]) {
            swap(idx, parentIdx)
            bubbleUp(parentIdx)
        }
    }

    private fun swap(idx1: Int, idx2: Int) {
        val temp = list[idx1]
        list[idx1] = list[idx2]
        list[idx2] = temp
    }

    private fun parentIndex(idx:Int) = (idx+1)/2 - 1

    private fun leftChildIndex(idx:Int) = idx*2 + 1
}
