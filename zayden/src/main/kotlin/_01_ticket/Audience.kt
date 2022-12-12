package _01_ticket

class Audience(
    val bag: Bag
) {
    fun buy(ticket: Ticket): Long {
        return when (bag.hasInvitation()) {
            true -> {
                bag.ticket = ticket
                0L
            }
            false -> {
                bag.minusAmount(ticket.fee)
                bag.ticket = ticket
                ticket.fee
            }
        }
    }
}
