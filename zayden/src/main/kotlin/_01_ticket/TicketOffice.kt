package _01_ticket

class TicketOffice(
    private val tickets: ArrayList<Ticket> = arrayListOf(),
    private var amount: Long
) {

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
