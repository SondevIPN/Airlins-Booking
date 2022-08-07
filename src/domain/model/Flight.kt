package domain.model

import domain.presentation.Formatter
import java.math.BigDecimal
import java.time.Duration
import java.time.format.DateTimeFormatter

data class Flight(
    val number:String,
    val airCraft: AirCraft,
    val price:BigDecimal,
    val derpartureArrivalBooking: Pair<AirportBooking,AirportBooking>,
    val duration: Duration = Duration.between(
        derpartureArrivalBooking.second.dateTime,
        derpartureArrivalBooking.first.dateTime)
)
