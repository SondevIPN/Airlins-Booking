package presentation.ticket.Formats

import domain.model.Ticket
import domain.model.baggage.pack.BaggagePackage
import domain.presentation.Formatter

class TicketConsoleFormat(
    private val baggagePackage: Formatter<BaggagePackage>
): Formatter<Ticket> {
    override fun format(t: Ticket): String {
        return """
            Passenger: ${t.passenger.name}
            Flight number: ${t.flight.number}
            Departure: ${t.flight.derpartureArrivalBooking.first.airport.name}
            Arrival: ${t.flight.derpartureArrivalBooking.second.airport.name}
            Flight price: $${t.flight.price}
            BaggagePlan: ${baggagePackage.format(t.baggagePackage)}
            Seat: ${t.seat.number}
            Total: $${t.totalPrice}
        """.trimIndent()
    }
}