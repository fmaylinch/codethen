package samples.algorithms

// Exercise Union-Find
// from book "Algorithms" (by Sedgewick, Wayne), chapter 1.5

fun main(args: Array<String>) {

    val system = UnionFind(10)

    system.union(4, 3)
    system.union(3, 8)
    system.union(6, 5)
    system.union(9, 4)
    system.union(2, 1)
    system.union(8, 9)
    system.union(5, 0)
    system.union(7, 2)
    system.union(6, 1)
    system.union(1, 0)
    system.union(6, 7)
}

/**
 * System of N sites with integer names (0 to N-1).
 * A group of connected sites is called a component.
 */
class UnionFind(n: Int) {

    val siteToComponent = Array(n) {it}
    val componentToSites = HashMap<Int, Set<Int>>()

    init {
        for (i in 0 until n) {
            componentToSites[i] = setOf(i)
        }
    }

    /** Add connection between p and q */
    fun union(p: Int, q: Int) {

        if (!connected(p, q)) {

            // Get component where q is now (qC), and its sites
            val qC = find(q)
            val sites = componentToSites[qC]!!

            // Move sites that were in qC to pC
            val pC = find(p)
            sites.forEach { siteToComponent[it] = pC }
            componentToSites[pC] = componentToSites[pC]!!.union(sites)

            // Remove old component for q (qC)
            componentToSites.remove(qC)

            println("Connected $p and $q; we have ${count()} components")
        }
    }

    /**
     * Returns component identifier for p (0 to N-1).
     */
    fun find(p: Int): Int {
        return siteToComponent[p]
    }

    /** Returns true if p and q are in the same component */
    fun connected(p: Int, q: Int): Boolean {
        return find(p) == find(q)
    }

    /** Number of components */
    fun count():Int {
        return componentToSites.size
    }
}