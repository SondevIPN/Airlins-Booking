package data.aircraft

import domain.datasource.aircraft.AircraftDataSource
import domain.model.AirCraft
import domain.model.seat.Seat
import domain.model.seat.seatClass
import domain.model.seat.SeatSection
import java.math.BigDecimal

class AircraftLocalSource : AircraftDataSource {
    override fun getAirCrafts(): List<AirCraft> = listOf(
        AirCraft("Airbus", "A320", getSeatSections()),
        AirCraft("Airbus", "A320", getSeatSections()),
        AirCraft("Airbus", "A320", getSeatSections())
    )

    private fun getSeatSections(): List<SeatSection> {
        return listOf(
            SeatSection(
                seatClass = seatClass.BUSINESS,
                seats = arrayOf(
                    Seat("1", BigDecimal(30), seatClass.BUSINESS),
                    Seat("2", BigDecimal(30), seatClass.BUSINESS),
                    Seat("3", BigDecimal(30), seatClass.BUSINESS),
                ),
                BigDecimal(30)
            ),
            SeatSection(
                seatClass = seatClass.PLUS,
                seats = arrayOf(
                    Seat("4", BigDecimal(20), seatClass.PLUS),
                    Seat("5", BigDecimal(20), seatClass.PLUS),
                    Seat("6", BigDecimal(20), seatClass.PLUS),
                ),
                BigDecimal(20)
            ),
            SeatSection(
                seatClass = seatClass.ECONOMY,
                seats = arrayOf(
                    Seat("7", BigDecimal(10), seatClass.ECONOMY),
                    Seat("8", BigDecimal(10), seatClass.ECONOMY),
                    Seat("9", BigDecimal(10), seatClass.ECONOMY),
                ),
                BigDecimal(10)
            )
        )
    }
}