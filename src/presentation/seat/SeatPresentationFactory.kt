package presentation.seat

import domain.model.seat.Seat
import domain.presentation.Formatter
import presentation.PresentationFactory
import presentation.PresentationFormat
import presentation.seat.formats.SeatConsoleFormat

class SeatPresentationFactory : PresentationFactory<Seat> {
    override fun getPresentationFormat(format: PresentationFormat): Formatter<Seat> {
        return SeatConsoleFormat()
    }
}