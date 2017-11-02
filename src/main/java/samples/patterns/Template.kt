package samples.patterns

/**
 * Example of the template pattern.
 * The Printer class has abstract methods that need to be implemented in subclasses.
 */
fun main(args: Array<String>) {

    val printer1 = HtmlPrinter()
    printer1.title = "Sample"
    printer1.paragraphs.add("one")
    printer1.paragraphs.add("two")
    printer1.print()

    println("---")

    val printer2 = MarkdownPrinter()
    printer2.title = "Sample"
    printer2.paragraphs.add("one")
    printer2.paragraphs.add("two")
    printer2.print()
}


abstract class Printer {

    var title = ""
    val paragraphs = ArrayList<String>()

    fun print() {
        // Note we can call abstract methods
        // They will do something in the subclasses (HtmlPrinter, etc)
        println(buildTitle(title))
        for (p in paragraphs) {
            println(buildParagraph(p))
        }

    }

    abstract fun buildTitle(t: String): String
    abstract fun buildParagraph(p: String): String
}

class HtmlPrinter : Printer() {

    override fun buildTitle(t: String): String {
        return "<h1>$t</h1>"
    }

    override fun buildParagraph(p: String): String {
        return "<p>$p</p>"
    }
}

class MarkdownPrinter : Printer() {

    override fun buildTitle(t: String): String {
        return "# " + t
    }

    override fun buildParagraph(p: String): String {
        return p
    }
}


