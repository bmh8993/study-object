package _01_ticket

class Bag(
    private var amount: Long,
    private val invitation: Invitation?
) {

    var ticket: Ticket? = null

    private fun hasInvitation(): Boolean {
        return invitation != null
    }

    private fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    private fun plusAmount(amount: Long) {
        this.amount += amount
    }

    fun hold(ticket: Ticket): Long {
        return when (hasInvitation()) {
            true -> {
                this.ticket = ticket
                0L
            }
            false -> {
                this.ticket = ticket
                minusAmount(ticket.fee)
                ticket.fee
            }
        }
    }
}
