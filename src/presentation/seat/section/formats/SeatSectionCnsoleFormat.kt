package presentation.seat.section.formats

import domain.model.seat.SeatSection
import domain.presentation.Formatter

class SeatSectionCnsoleFormat : Formatter<SeatSection> {
    override fun format(t: SeatSection): String {
        return """
            Seat Class: ${t.seatClass.name}
            Price: $${t.price}
        """.trimIndent()
    }
}