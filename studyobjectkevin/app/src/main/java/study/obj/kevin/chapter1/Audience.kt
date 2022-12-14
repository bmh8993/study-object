package study.obj.kevin.chapter1

import study.obj.kevin.chapter1.ticket.Ticket

class Audience constructor(bag: Bag) {

    //가방이라는 존재는 원래 수동적인 존재가 아닌가? -> 모든 것이 수동적인 존재에서 능동적인 존재로 변경 된다 의인화
    //객체지향에서의 올바른 구현 -> 모든 객채들이 자율적인 존재가 되는 것
    private val bag: Bag = bag

    fun getBag() = bag

    fun buy(ticket: Ticket) = bag.hold(ticket)
}