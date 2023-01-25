package ch11

import java.time.Duration

class RegularPolicy constructor(
    private val amount: Money,
    private val seconds: Duration
) : BasicRatePolicy() {
    override fun calculateCallFee(call: Call): Money {
        val value = call.getDuration().seconds / seconds.seconds
        return amount.times(value.toDouble())
    }
}