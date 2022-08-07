package domain.usecases.flight

import domain.datasource.flight.FlightDataSource
import domain.model.AirCraft
import domain.model.Airport
import domain.model.AirportBooking
import domain.model.Flight
import domain.presentation.Formatter
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.Month

class GetFights(
    private val flightDataSource: FlightDataSource
) {
    fun invoke(month: Month): Map<Int, Flight> {
        return flightDataSource
            .getFlights()
            .filter { flightEntry ->
                flightEntry.value.derpartureArrivalBooking.first.dateTime.month == month
            }
    }
}