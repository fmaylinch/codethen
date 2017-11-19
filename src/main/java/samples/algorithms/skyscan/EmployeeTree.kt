package samples.algorithms.skyscan

import java.util.*

fun main(args: Array<String>) {

    val input =
      """
        sarah roger
        sarah susan
        roger mark
        roger tom
        tom larry
        susan john
        susan warren
      """

    val sky = Scanner(input)

    val treeManager = TreeManager("sarah")

    while (sky.hasNextLine()) {

        val line = sky.nextLine().trim()

        if (line != "") {
            //println("line: $line")
            val names = line.split(" ")
            treeManager.addRelationship(names[0], names[1])
        }
    }

    println( treeManager.rootNode.toString(0) )

    println()

    print( treeManager.ancestors("tom") )
}

class TreeManager(root: String) {

    private val nodes = mutableMapOf<String, TreeNode>()
    val rootNode: TreeNode = TreeNode(root, null, null, null)

    init {
        nodes.put(root, rootNode)
    }

    fun addRelationship(parent: String, child: String) {

        if (nodes.containsKey(child)) {
            throw IllegalArgumentException("Child $child was already added")
        }
        val parentNode = nodes[parent] ?: throw IllegalArgumentException("Parent $parent was not added before")

        val childNode = TreeNode(child, parentNode, null, null)
        nodes.put(child, childNode)

        when {
            parentNode.left == null -> parentNode.left = childNode
            parentNode.right == null -> parentNode.right = childNode
            else -> throw IllegalArgumentException("Parent $parent already has 2 children")
        }
    }

    fun ancestors(value: String): List<String> {

        val result = mutableListOf(value)

        var node = nodes[value]!!

        while (node.parent != null) {
            node = node.parent!!
            result.add(node.value)
        }

        return result
    }
}

class TreeNode(var value:String, var parent:TreeNode?, var left:TreeNode?, var right:TreeNode?) {

    fun toString(indent:Int):String {

        val leftStr = left?.toString(indent+2) ?: ""
        val rightStr = right?.toString(indent+2) ?: ""

        return "\n" + " ".repeat(indent) + value + leftStr + rightStr
    }
}