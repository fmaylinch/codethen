package samples.patterns

import java.util.ArrayList

/**
 * Example of the Observer pattern.
 * The Detector is the observable, and the Listener is the observer.
 * The Detector notifies the Listeners when it detects objects.
 */
fun main(args: Array<String>) {

    val detector = Detector()

    val listener1 = Listener()
    val listener2 = Listener()
    val listener3 = Listener()

    // Multiple listeners can subscribe to get notified
    detector.addListener(listener1)
    detector.addListener(listener2)
    detector.addListener(listener3)

    // Simulate that the detector detected 2 objects
    detector.detect(2)
}



/** Observable */
class Detector {

    private val listeners = ArrayList<Listener>()

    fun addListener(listener: Listener) {
        listeners.add(listener)
    }

    fun detect(n: Int) {
        // Notify all the listeners
        for (listener in listeners) {
            // We decide what data we pass from the Observable to the Observer
            listener.notify(n)
        }
    }
}

/** Observer */
class Listener {

    // We decide what data we pass from the Observable to the Observer
    fun notify(n: Int) {
        println("Listener notified with value: $n")
    }

}
