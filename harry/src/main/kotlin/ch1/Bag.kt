package ch1

class Bag(
    private var amount: Long,
    private val invitation: Invitation?,
    private var ticket: Ticket?
) {
    constructor(amount: Long) : this(amount, null, null)
    constructor(invitation: Invitation, amount: Long) : this(amount, invitation, null)

    fun hold(ticket: Ticket): Long {
        return if (hasInvitation()) {
            setTicket(ticket)
            0L
        } else {
            setTicket(ticket)
            minusAmount(ticket.getFee())
            ticket.getFee()
        }
    }

    private fun hasInvitation(): Boolean = invitation != null

    fun hasTicket(): Boolean = ticket != null

    private fun setTicket(ticket: Ticket) {
        this.ticket = ticket
    }

    private fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }
}
