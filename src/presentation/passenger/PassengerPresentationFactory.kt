package presentation.passenger

import domain.model.Passenger
import domain.presentation.Formatter
import presentation.PresentationFactory
import presentation.PresentationFormat
import presentation.passenger.formats.PassengerConsoleFormat

class PassengerPresentationFactory : PresentationFactory<Passenger> {
    override fun getPresentationFormat(format: PresentationFormat): Formatter<Passenger> {
        return PassengerConsoleFormat()
    }

}