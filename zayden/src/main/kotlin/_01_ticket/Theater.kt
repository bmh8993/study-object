package _01_ticket

class Theater(
    private val ticketSeller: TicketSeller
) {
    // 수정 전: 너무 많은 클래스에 의존하고 있다.
    // 수정 후: ticketSeller의 sellTo의 인터페이스만 알고있다. 메세지를 전달할 뿐이다.
    fun enter(audience: Audience) {
        ticketSeller.sellTo(audience)
    }
}
