package presentation.flight.formats

import domain.model.Flight
import domain.presentation.Formatter
import java.time.format.DateTimeFormatter

class FlightConsoleFormat: Formatter<Flight> {
    override fun format(t: Flight): String {
        val departure = t.derpartureArrivalBooking.first
        val arrival = t.derpartureArrivalBooking.second
        return """
            ${t.number}
            Origin ${departure.airport.name}
            Origin DateTime ${departure.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}
            Arrival ${arrival.airport.name}
            Arrival DateTime ${departure.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}
            Duration ${t.duration}
            Price $${t.price}
            
        """.trimIndent()
    }
}