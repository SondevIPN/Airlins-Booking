package domain.usecases.flight.di

import data.aircraft.AircraftLocalSource
import data.airport.AirportLocalSource
import data.airportbook.AirBookingLocalSource
import data.flight.FlightLocalSource
import domain.datasource.flight.FlightDataSource

class FlightDataDI {
    fun providesFlightsData() : FlightDataSource {
        val airportDataSource = AirportLocalSource()
        val airportBookingLocalSource = AirBookingLocalSource(airportDataSource)
        val aircraftLocalSource = AircraftLocalSource()
        return FlightLocalSource(
            aircraftLocalSource, airportBookingLocalSource
        )
    }
}