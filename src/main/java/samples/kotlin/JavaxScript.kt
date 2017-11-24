package samples.kotlin

import javax.script.ScriptEngineManager

fun main(args: Array<String>) {

    val manager = ScriptEngineManager()

    manager.engineFactories.forEach {
        println(it.engineName)
    }

    println("getting js engine")
    val jsEngine = manager.getEngineByExtension("js")
    println("evaluating")
    jsEngine.eval("var x = 3;")
    jsEngine.put("y", 2)
    println(jsEngine.eval("x + y"))  // Prints out 5

    println("getting kts engine")
    val ktEngine = manager.getEngineByExtension("kts")
    println("evaluating")
    ktEngine.eval("val x = 3")
    ktEngine.eval("val y = 2")
    println(ktEngine.eval("x + y"))  // Prints out 5
}