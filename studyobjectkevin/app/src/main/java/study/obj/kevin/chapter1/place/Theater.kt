package study.obj.kevin.chapter1.place

import study.obj.kevin.chapter1.Audience
import study.obj.kevin.chapter1.ticket.Ticket
import study.obj.kevin.chapter1.ticket.TicketSeller

class Theater constructor(ticketSeller: TicketSeller) {
    private var ticketSeller: TicketSeller = ticketSeller

    fun enter(audience: Audience) {
        ticketSeller.sellTo(audience)
    }
}