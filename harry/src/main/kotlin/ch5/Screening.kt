package ch5

import java.time.LocalDateTime

//1. 예매하라에 응답하는 메서드 구현
//2. 책임이 결정되었으니 책임을 수행하는데 필요한 변수 구현
class Screening constructor(
    private val movie: Movie,
    val sequence: Int,
    val whenScreened: LocalDateTime
) {
    fun reserve(customer: Customer, audienceCount: Int): Reservation {
        return Reservation(customer, this, calculateFee(audienceCount), audienceCount)
    }

    private fun calculateFee(audienceCount: Int): Money {
        return movie.calculateMovieFee(this).times(audienceCount.toDouble())
    }
}