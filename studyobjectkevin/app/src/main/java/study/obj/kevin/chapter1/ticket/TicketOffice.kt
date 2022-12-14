package study.obj.kevin.chapter1.ticket

import study.obj.kevin.chapter1.Audience

class TicketOffice constructor(amount: Long, tickets: MutableList<Ticket>) {
    private var amount: Long = amount
    private var tickets: MutableList<Ticket> = tickets

    fun sellTicketTo(audience: Audience) {
        plusAmount(audience.buy(getTicket()))
    }

    fun getTicket(): Ticket {
        return tickets.removeAt(0)
    }

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }
}