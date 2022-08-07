package presentation.reservation

import domain.model.Reservation
import domain.presentation.Formatter
import presentation.PresentationFactory
import presentation.PresentationFormat
import presentation.baggage.BaggagePackageConsole
import presentation.baggage.types.BaggageTypesConsole
import presentation.reservation.format.ReservationConsoleFormat
import presentation.ticket.Formats.TicketConsoleFormat

class ReservationPresentationFactory : PresentationFactory<Reservation> {
    override fun getPresentationFormat(format: PresentationFormat): Formatter<Reservation> {
        return ReservationConsoleFormat(
            TicketConsoleFormat(
                BaggagePackageConsole(
                    BaggageTypesConsole()
                )
            )
        )
    }
}