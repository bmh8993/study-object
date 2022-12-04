package ch1

import java.util.*


class TicketOffice(
    private var amount: Long,
    private var tickets: List<Ticket>
) {

    fun sellTicketTo(audience: Audience) {
        plusAmount(audience.buy(getTicket()))
    }

    fun getTicket(): Ticket {
        val ticket = tickets[0]
        tickets = tickets.subList(1, tickets.size)
        return ticket
    }

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }
}