package _01_ticket

class TicketSeller(
    val ticketOffice: TicketOffice
) {
    // 수정 전: audience는 여전히 자율적인 존재가 아니다.
    // 수정 후: audience는 자율적인 존재가 되었다.
    fun sellTo(audience: Audience) {
        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()))
    }
}
