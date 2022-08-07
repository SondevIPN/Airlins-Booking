package presentation.seat.section

import domain.model.seat.SeatSection
import domain.presentation.Formatter
import presentation.PresentationFactory
import presentation.PresentationFormat
import presentation.seat.section.formats.SeatSectionCnsoleFormat

class SeatSectionPresentationFactory : PresentationFactory<SeatSection> {
    override fun getPresentationFormat(format: PresentationFormat): Formatter<SeatSection> {
        return SeatSectionCnsoleFormat()
    }
}