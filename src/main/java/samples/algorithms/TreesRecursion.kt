package samples.algorithms

/**
 * Example about trees and recursion (e.g. factorial or tree processing).
 */

fun main(args: Array<String>) {

    val t1 = TreeNode(1, null, null)
    val t4 = TreeNode(4, null, null)
    val t3 = TreeNode(3, t1, t4)
    val t6 = TreeNode(6, null, null)
    val t5 = TreeNode(5, t3, t6)

    //          5
    //        /   \
    //       3     6
    //     /   \
    //    1    4

    val tree =
      TreeNode(5,
        TreeNode(3,
          TreeNode(1),
          TreeNode(4)),
        TreeNode(6))

    println("Total sum of tree: ${sumTree(tree)}")

    println("Tree printed in order")
    printInOrder(tree)

    // TODO: searchInTree(t5, 3)

    val n = 5
    println("$n! = ${factorial(n)}")
}

class TreeNode(var value: Int, var left: TreeNode?, var right: TreeNode?) {

    constructor(value: Int) : this(value, null, null)
}

/** Returns the sum of all nodes in the tree */
fun sumTree(tree: TreeNode): Int {

    val left = tree.left
    val right = tree.right

    val sumLeft = if (left != null) sumTree(left) else 0
    val sumRight = if (right != null) sumTree(right) else 0

    val result = tree.value + sumLeft + sumRight
    //println("result $result for node with ${tree.value}")

    return result
}

/** Prints the numbers of a sorted binary tree */
fun printInOrder(tree: TreeNode) {

    val left = tree.left
    val right = tree.right

    if (left != null) {
        printInOrder(left)
    }

    println(tree.value)

    if (right != null) {
        printInOrder(right)
    }
}

fun factorial(n: Int): Int {

    if (n <= 1) {
        return 1 // trivial case
    } else {
        return n * factorial(n - 1) // recursive case
    }
}
