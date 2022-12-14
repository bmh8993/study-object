package study.obj.kevin.chapter1.ticket

import study.obj.kevin.chapter1.Audience

class TicketSeller constructor(ticketOffice: TicketOffice) {

    private var ticketOffice: TicketOffice = ticketOffice
    fun getTicketOffice() = ticketOffice

    //캡슐화의 목적 : 변경하기 쉬운 코드를 만드는 것
    fun sellTo(audience: Audience) {
        /*val ticket = ticketOffice.getTicket()
        if (audience.getBag().hasInvitation()) {
            audience.getBag().setTicket(ticket.copy())
        } else {
            audience.getBag().minusAmount(ticket.fee)
            ticketOffice.plusAmount(ticket.fee)
            audience.getBag().setTicket(ticket)
        }*/
        //ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()))
        ticketOffice.sellTicketTo(audience)
    }

}