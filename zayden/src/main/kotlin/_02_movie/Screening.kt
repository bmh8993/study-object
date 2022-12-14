package _02_movie

import java.time.LocalDateTime

class Screening(
    private val movie: Movie,
    private val sequence: Int,
    private val senScreened: LocalDateTime
) {

    fun getStartTime(): LocalDateTime {
        return this.senScreened
    }

    fun isSequence(sequence: Int): Boolean {
        return this.sequence == sequence
    }

    fun getMovieFee(): Money {
        return movie.fee
    }

    fun reserve(customer: Customer, audienceCount: Int): Reservation {
        return Reservation(
            customer = customer,
            screening = this,
            fee = calculateFee(audienceCount),
            audienceCount = audienceCount
        )
    }

    private fun calculateFee(audienceCount: Int): Money {
        return movie.calculateMovieFee(this).times(audienceCount.toDouble())
    }
}
