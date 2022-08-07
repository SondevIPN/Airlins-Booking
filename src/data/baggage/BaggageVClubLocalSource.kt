package data.baggage

import domain.model.baggage.pack.BaggagePackage
import domain.model.baggage.pack.vclub.ClubBassic
import domain.model.baggage.pack.vclub.ClubClassic
import domain.model.baggage.pack.vclub.ClubPlus

class BaggageVClubLocalSource : BaggagePackageLocalSource() {
    override fun getBaggagePacks(): Map<Int, BaggagePackage> {
        return mapOf(
            1 to ClubBassic(price),
            2 to ClubClassic(price),
            3 to ClubPlus(price)
        )
    }
}