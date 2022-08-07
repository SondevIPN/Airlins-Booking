package domain.model.seat

import java.math.BigDecimal

data class SeatSection(
    val seatClass: seatClass,
    val seats: Array<Seat>,
    val price: BigDecimal
)
