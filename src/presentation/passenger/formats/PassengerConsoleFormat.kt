package presentation.passenger.formats

import domain.model.Passenger
import domain.presentation.Formatter

class PassengerConsoleFormat : Formatter<Passenger> {
    override fun format(t: Passenger): String {
        return """
            Name: ${t.name}
            Email: ${t.email}
            Phone: ${t.phone}
        """.trimIndent()
    }
}