package study.obj.kevin.chapter1

import study.obj.kevin.chapter1.ticket.Ticket

//가방
class Bag constructor(
    private val invitation: Invitation? = null,
    private var amount: Long
) {
    private lateinit var ticket: Ticket
    /*
    constructor(amount: Long) {
        this.amount = amount
    }
    constructor(invitation: Invitation, amount: Long) {
        this.invitation = invitation
        this.amount = amount
    }*/

    fun hold(ticket: Ticket): Long {
        if (hasInvitation()) {
            setTicket(ticket)
            return 0L
        } else {
            setTicket(ticket)
            minusAmount(ticket.fee)
            return ticket.fee
        }
    }

    fun hasInvitation() = invitation != null
    fun hasTicket() = ticket != null

    fun setTicket(ticket: Ticket) {
        this.ticket = ticket
    }

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }

}