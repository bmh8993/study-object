package _01_ticket

class TicketSeller(
    private val ticketOffice: TicketOffice
) {
    // 수정 전: audience는 여전히 자율적인 존재가 아니다.
    // 수정 후: audience는 자율적인 존재가 되었다.

    // ticketOffice에게 자율성을 부여하게 되면(ex. sellTicketTo(audience: Audience), 오히려 audience에게 의존하게 되고 결합도가 높아지게 된다.
    // 트레이드 오프가 발생하는데, 이건 논의를 해봐야한다.
    // 내 생각에는 아무래도 audience에게 의존하는 객체가 제일 적어야할 것 같다. 가장 중심이 되는 객체라고 생각된다.

    fun sellTo(audience: Audience) {
        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()))
    }
}
