package presentation.ticket

import domain.model.Ticket
import domain.presentation.Formatter
import presentation.PresentationFactory
import presentation.PresentationFormat
import presentation.baggage.BaggagePackageConsole
import presentation.baggage.types.BaggageTypesConsole
import presentation.ticket.Formats.TicketConsoleFormat

class TicketPresentationFactory : PresentationFactory<Ticket> {
    override fun getPresentationFormat(format: PresentationFormat): Formatter<Ticket> {
        return TicketConsoleFormat(
            BaggagePackageConsole(
                BaggageTypesConsole()
            )
        )
    }
}