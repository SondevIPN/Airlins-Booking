package presentation.flight.formats

import domain.model.Flight
import domain.presentation.Formatter
import java.time.format.DateTimeFormatter

class FlightHTMLFormat: Formatter<Flight> {
    override fun format(flight: Flight): String {
        val departure =flight.derpartureArrivalBooking.first
        val arrival = flight.derpartureArrivalBooking.second
        return """
            <p><strong>${flight.number}</strong><br />
            Origin ${departure.airport.name}<br />
            Origin DateTime ${departure.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}<br />
            Arrival ${arrival.airport.name}<br />
            Arrival DateTime ${departure.dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)}<br />
            Duration ${flight.duration}<br />
            Price $${flight.price}<br/>
            </p>
            
        """.trimIndent()
    }

}