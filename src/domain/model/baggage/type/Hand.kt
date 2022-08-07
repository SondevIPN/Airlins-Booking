package domain.model.baggage.type

class Hand() : BaggageType(){
    override val emoji: String = "🎒"
    override val title: String= "Hand Baggage"
    val warning: String = "Warning Message"
}
