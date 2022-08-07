package domain.datasource.aircraft

import domain.model.AirCraft

interface AircraftDataSource {
    fun getAirCrafts(): List<AirCraft>
}