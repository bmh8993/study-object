package _05_movie_rdd

import java.time.LocalDateTime

class Screening(
    private val movie: Movie,
    val sequence: Int,
    val whenScreened: LocalDateTime
) {
    fun getStartTime(): LocalDateTime {
        return this.whenScreened
    }

    fun isSequence(sequence: Int): Boolean {
        return this.sequence == sequence
    }
    fun reserve(customer: Customer, audienceCount: Int): Reservation {
        return Reservation(
            customer = customer,
            screening = this,
            fee = calculateFee(audienceCount),
            audienceCount = audienceCount
        )
    }

    /**
     * calculateMovieFee: Movie의 내부 구현에 대해서 어떤 지식도 없이, 메시지 송신자인 Screening의 의도를 표현하고 있다.
     */
    private fun calculateFee(audienceCount: Int): Money {
        return movie.calculateMovieFee(this).times(audienceCount.toDouble())
    }
}
