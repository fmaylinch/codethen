package samples.patterns

/**
 * Example of 2 patterns: Adapter and Factory.
 * They are not related, but they play well together here.
 *
 * We have 3 adapters for 3 different flight companies.
 * All the adapters implement the same interface FlightPurchaser,
 * so all the adapters can be used the same way by the method processFlight.
 *
 * The FlightPurchaserFactory can return the appropriate adapter
 * for a given flight. A factory returns an instance of some type
 * (here FlightPurchaser), but we don't need to know the exact type of
 * the object (here it can be one of the available adapters).
 */
fun main(args: Array<String>) {

    /*
    val airAisaAdapter : FlightPurchaser = AirAsiaAdapter(AirAsia())
    val finnAirAdapter : FlightPurchaser = FinnAirAdapter(FinnAir())
    val iberiaAdapter : FlightPurchaser = IberiaAdapter(Iberia())
    */

    val flight = 100
    val adapter = FlightPurchaserFactory().getFromFlight(flight)

    processFlight(adapter, flight)
}


// These are the classes we have to unify with adapters.
// We imagine they are actually implemented; we leave them empty in this example.

class AirAsia {
    fun reserveFlight(flight: Int) { }
    fun purchaseFlight(flight: Int) { }
}

// In FinnAir we imagine it's necessary to lock a flight before reserving
class FinnAir {
    fun lock(flight: Int) { }
    fun reserve(flight: Int) { }
    fun purchase(flight: Int) { }
}

// Iberia can't have reservations, you just purchase directly
class Iberia {
    fun purchase(flight: Int) { }
}


/** The adapters have to implement this interface */
interface FlightPurchaser {
    fun reservationSupported():Boolean
    fun reserve(flight: Int)
    fun purchase(flight: Int)
}


// The adapters:

class IberiaAdapter(val iberia: Iberia) : FlightPurchaser {

    override fun reservationSupported(): Boolean {
        return false
    }

    override fun reserve(flight: Int) {
        throw RuntimeException("Can't do this")
    }

    override fun purchase(flight: Int) {
        iberia.purchase(flight)
    }
}

class AirAsiaAdapter(val airAsia: AirAsia) : FlightPurchaser {

    override fun reservationSupported(): Boolean {
        return true
    }

    override fun reserve(flight: Int) {
        airAsia.reserveFlight(flight)
    }

    override fun purchase(flight: Int) {
        airAsia.purchaseFlight(flight)
    }
}

class FinnAirAdapter(val finnAir: FinnAir) : FlightPurchaser {

    override fun reservationSupported(): Boolean {
        return true
    }

    override fun reserve(flight: Int) {
        finnAir.lock(flight)
        finnAir.reserve(flight)
    }

    override fun purchase(flight: Int) {
        finnAir.purchase(flight)
    }
}



/** Use of factory pattern */
class FlightPurchaserFactory {

    /** Returns the appropriate purchaser for the given flight */
    fun getFromFlight(flight: Int) : FlightPurchaser {

        if (flight > 1000) {
            return IberiaAdapter(Iberia())
        } else if (flight > 500) {
            return AirAsiaAdapter(AirAsia())
        } else {
            return FinnAirAdapter(FinnAir())
        }
    }
}

/** Performs all the necessary process to purchase a flight using the given purchaser */
fun processFlight(purchaser: FlightPurchaser, flight: Int) {

    if (purchaser.reservationSupported()) {
        purchaser.reserve(flight)
    }

    purchaser.purchase(flight)
}
