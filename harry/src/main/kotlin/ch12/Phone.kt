package ch11

import java.util.*

class Phone constructor(
    private val ratePolicy: RatePolicy
) {

    private val calls: List<Call> = listOf()

    fun getCalls(): List<Call> {
        return calls
    }

    fun calculateFee(): Money {
        return ratePolicy.calculateFee(this)
    }
}