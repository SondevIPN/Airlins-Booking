import data.baggage.BaggageRegularLocalSource
import data.baggage.BaggageVClubLocalSource
import data.reservation.ReservationSingleton
import domain.model.Flight
import domain.model.Passenger
import domain.model.baggage.pack.BaggagePackage
import domain.model.seat.Seat
import domain.model.seat.SeatSection
import domain.presentation.Formatter
import domain.usecases.baggage.GetBaggagePackage
import domain.usecases.baggage.GetBaggageSaved
import domain.usecases.flight.GetFights
import domain.usecases.flight.GetFlightSaved
import domain.usecases.flight.di.FlightDataDI
import domain.usecases.reservation.AssignTicketToReservation
import domain.usecases.reservation.GetReservation
import domain.usecases.seat.GetSeatBy
import domain.usecases.seat.GetSeatSaved
import domain.usecases.seat.GetSeatsSection
import domain.usecases.ticket.*
import domain.usecases.ticket.di.TicketDataDI
import presentation.BaggagePackPresentationFactory
import presentation.PresentationFormat
import presentation.baggage.BaggagePackageEnum
import presentation.extfunction.isBlankOrEmpty
import presentation.extfunction.isNumber
import presentation.flight.FlightPresentationFactory
import presentation.flight.formats.FlightConsoleFormat
import presentation.menu.UIInputData
import presentation.menu.UIMenu
import presentation.passenger.PassengerPresentationFactory
import presentation.reservation.ReservationPresentationFactory
import presentation.seat.SeatPresentationFactory
import presentation.seat.section.SeatSectionPresentationFactory
import java.time.Month

fun main() {
    val format = PresentationFormat.CONSOLE
    val flightPresentation = FlightPresentationFactory().getPresentationFormat(format)
    val baggagePackagePresentation = BaggagePackPresentationFactory().getPresentationFormat(format)
    val seatSectionPresentation = SeatSectionPresentationFactory().getPresentationFormat(format)
    val seatPresentation = SeatPresentationFactory().getPresentationFormat(format)
    val passengerPresentation = PassengerPresentationFactory().getPresentationFormat(format)
    val reservationPresentation = ReservationPresentationFactory().getPresentationFormat(format)
    val ticketData = TicketDataDI().providesTicketsData()
    val flightData = FlightDataDI().providesFlightsData()
    val reservationSingleton = ReservationSingleton()

    val uiMenu = object : UIMenu<Flight> {}
    val flightsMap = GetFights(flightData).invoke(Month.JANUARY)
    val flightSelected = uiMenu.showMenu(flightsMap, flightPresentation)

    AssingFlightToTicket(ticketData).invoke(flightSelected)

    val getFlightSaved = GetFlightSaved(ticketData)
    val flightSaved = getFlightSaved()
    println(FlightConsoleFormat().format(flightSaved))

    val baggagePackOption = mapOf(
        1 to BaggagePackageEnum.REGULAR,
        2 to BaggagePackageEnum.VCLUB
    )
    val uiMenuBaggagePackageOpt = object : UIMenu<BaggagePackageEnum>{}
    val baggagePackageOption = uiMenuBaggagePackageOpt.showMenu(
        baggagePackOption, object : Formatter<BaggagePackageEnum>{
            override fun format(t: BaggagePackageEnum): String = t.name
        }
    )
    val baggagePackageData = when (baggagePackageOption){
        BaggagePackageEnum.REGULAR -> BaggageRegularLocalSource()
        BaggagePackageEnum.VCLUB -> BaggageVClubLocalSource()
        else -> BaggageRegularLocalSource()
    }

    val baggagePackageMap = GetBaggagePackage(baggagePackageData).invoke()
    val uiMenuBaggagePackage = object : UIMenu<BaggagePackage>{}
    val baggagePackageSelected = uiMenuBaggagePackage.showMenu(
        baggagePackageMap, baggagePackagePresentation
    )

    AssingBaggagePackToTicket(ticketData).invoke(baggagePackageSelected)
    val baggagePackSaved = GetBaggageSaved(ticketData).invoke()
    println("Baggage Package Saved")
    println(
        baggagePackagePresentation.format(baggagePackSaved)
    )

    val seatSectionMap = GetSeatsSection(
        getFlightSaved
    ).invoke()

    val uiSeatsSectionsMenu = object : UIMenu<SeatSection> { }
    val seatSectionSelected = uiSeatsSectionsMenu.showMenu(
        seatSectionMap, seatSectionPresentation
    )

    val seatsMap = GetSeatBy().invoke(seatSectionSelected)
    val uiSeatsMenu = object : UIMenu<Seat> { }
    val seatSelected = uiSeatsMenu.showMenu(seatsMap, seatPresentation)

    AssignSeatToTicket(ticketData).invoke(seatSelected)
    val seatSaved = GetSeatSaved(ticketData).invoke()

    println("Seat Saved")
    println(
        seatPresentation.format(seatSaved)
    )

    /** 7. Introduce Information Passenger **/
    var passengerQty = ""
    do {
        println("How many passengers are?")
        passengerQty = readLine().orEmpty()
    }while (!passengerQty.isNumber())

    val passengers = (1 .. passengerQty.toInt()).map {
        println("Passenger: $it")
        val uiInputData = object : UIInputData { }
        val name = uiInputData.requestField("Name")
        val email = uiInputData.requestField("Email")
        val number = uiInputData.requestField("Phone")
        Passenger(name, email, number)
    }
    AssignPassengerToTicket(ticketData).invoke(passengers)
    println(
        passengerPresentation.format(passengers)
    )

    /**8. Get Reservation **/
    AssignTicketToReservation(
        ReservationSingleton(), GetTicket(ticketData)
    ).invoke()

    val reservation = GetReservation(reservationSingleton)
        .invoke()
    println()
    println("*** Reservation ***")
    println(
        reservationPresentation.format(reservation)
    )
    println()
}
