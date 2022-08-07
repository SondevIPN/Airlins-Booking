package presentation.ticket.Formats

import domain.model.Ticket
import domain.presentation.Formatter

class TicketHTMLFormat: Formatter<Ticket>{
    override fun format(t: Ticket): String {
        return """
            <p><strong>Passenger: ${t.passenger.name}</strong><br />
            Flight number: ${t.flight.number}<br />
            Departure: ${t.flight.derpartureArrivalBooking.first.airport.name}<br />
            Arrival: ${t.flight.derpartureArrivalBooking.second.airport.name}<br />
            Flight price: $${t.flight.price}<br />
            BaggagePlan: $//{baggage.format()}<br />
            Seat: ${t.seat.number}<br />
            Total: $${t.totalPrice}<br />
            </p>
        """.trimIndent()
    }
}