package ch1

class Audience(
    private val bag: Bag
) {
    fun getBag(): Bag = bag

    fun buy(ticket:Ticket): Long {
        return bag.hold(ticket)
    }
}