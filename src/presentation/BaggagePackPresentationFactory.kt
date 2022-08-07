package presentation

import domain.model.baggage.pack.BaggagePackage
import domain.presentation.Formatter
import presentation.baggage.BaggagePackageConsole
import presentation.baggage.types.BaggageTypesConsole

class BaggagePackPresentationFactory : PresentationFactory<BaggagePackage> {
    override fun getPresentationFormat(format: PresentationFormat): Formatter<BaggagePackage> {
        return BaggagePackageConsole(
            BaggageTypesConsole()
        )
    }
}