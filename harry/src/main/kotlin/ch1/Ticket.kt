package ch1

class Ticket(
    private val fee: Long
) {
    fun getFee(): Long = fee
}