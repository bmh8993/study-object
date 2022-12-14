package study.obj.kevin.chapter2

class Reservation constructor(
    private val customer: Customer,
    private val screening: Screening,
    private val fee: Money,
    private val audienceCount: Int
) {

}