package samples.patterns

/**
 * Example of the Builder pattern.
 * The Label.Builder class creates instances of Label.
 */
fun main(args: Array<String>) {

    val builder = Label.Builder().color(3).size(10)

    // We can reuse the builder (see the build method)
    val label1 = builder.text("hello").build()
    val label2 = builder.text("bye").build()
    val label3 = builder.text("hi").build()
}


class Label {

    var text: String = ""
    var color: Int = 0
    var size: Int = 0

    class Builder {

        val label = Label()

        fun text(t: String) : Builder {
            label.text = t
            return this
        }

        fun color(c: Int) : Builder {
            label.color = c
            return this
        }

        fun size(s: Int) : Builder {
            label.size = s
            return this
        }

        fun build() : Label {

            // We can check we have all the necessary values
            if (label.size == 0) {
                throw RuntimeException("size can't be 0")
            }

            // We return a new label so we can reuse the builder
            val result = Label()
            result.text = label.text
            result.color = label.color
            result.size = label.size
            return result
        }
    }
}
