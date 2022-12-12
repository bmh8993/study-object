package _01_ticket

class Bag(
    private var amount: Long,
    private val invitation: Invitation?
) {

    var ticket: Ticket? = null

    fun hasInvitation(): Boolean {
        return invitation != null
    }

    fun hasTicket(): Boolean {
        return ticket != null
    }

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }
}
