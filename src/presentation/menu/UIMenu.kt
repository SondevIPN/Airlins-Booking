package presentation.menu

import domain.presentation.Formatter
import presentation.extfunction.isMenuOptionValid
import presentation.flight.formats.FlightConsoleFormat
import java.util.*

interface UIMenu<T> {
    fun showMenu(
        mapObjects: Map<Int, T>,
        formatter: Formatter<T>
    ) : T?{
        var option: String = ""
        do {
            mapObjects.forEach { (t, u) ->
                println("$t. ")
                println(formatter.format(u))
            }
            println("*** Select Number Option ***")
            option = readLine().orEmpty()
        }while (!option.isMenuOptionValid(mapObjects))

        println()
        return mapObjects[option.toInt()]
    }
}