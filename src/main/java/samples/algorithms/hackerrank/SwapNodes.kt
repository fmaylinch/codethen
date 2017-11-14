package samples.algorithms.hackerrank

import java.util.*

/**
 * https://www.hackerrank.com/challenges/swap-nodes-algo
 */
fun main(args: Array<String>) {

    val input =
      """
      """

    val sc = Scanner(System.`in`)

    val n = sc.nextInt()

    val tree = SwapTree(n)

    for (i in 1..n) {
        val a = sc.nextInt()
        val b = sc.nextInt()
        tree.addNode(a, b)
    }

    val t = sc.nextInt()
    for (i in 1..t) {
        val k = sc.nextInt()
        tree.swap(1, 1, k)
        tree.printInOrder(1)
        println()
    }
}

class SwapTree(val numNodes:Int) {

    // We won't use index 0
    val nodes = ArrayList<Pair<Int, Int>>(numNodes+1)

    init {
        nodes.add(Pair(0,0)) // First index is ignored
    }

    fun addNode(leftIndex: Int, rightIndex: Int) {
        nodes.add(Pair(leftIndex,rightIndex))
    }

    /** Swaps subtrees of nodes with a level that is multiple of k */
    fun swap(nodeIdx: Int, level: Int, k: Int) {

        if (nodeIdx == -1) return

        val node = nodes[nodeIdx]

        if (level % k == 0) {
            nodes[nodeIdx] = Pair(node.second, node.first)
        }

        swap(node.first, level+1, k)
        swap(node.second, level+1, k)
    }

    fun printInOrder(nodeIdx: Int) {

        if (nodeIdx == -1) return

        val node = nodes[nodeIdx]

        printInOrder(node.first)
        print("$nodeIdx ")
        printInOrder(node.second)
    }
}
