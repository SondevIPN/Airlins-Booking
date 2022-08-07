package domain.usecases.reservation

import domain.datasource.reservation.ReservationDataSource
import domain.model.Reservation
import domain.usecases.ticket.GetTicket

private const val CODE_SIZE = 5
class AssignTicketToReservation(
    private val reservationDataSource: ReservationDataSource,
    private val getTicket: GetTicket
) {
    operator fun invoke(): Reservation{
        return reservationDataSource.reservation.apply {
            this.code = generateCode()
            this.departureTickets = getTicket()
            this.returnTickets = getTicket()
        }
    }

    private fun generateCode(): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1 .. CODE_SIZE).map {
            allowedChars.random()
        }.joinToString ("")
    }
}