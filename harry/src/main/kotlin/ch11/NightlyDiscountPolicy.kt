package ch11

import ch10.NightlyDiscountPhone
import java.time.Duration

class NightlyDiscountPolicy constructor(
    private val amount: Money,
    private val seconds: Duration
) : BasicRatePolicy() {

    override fun calculateCallFee(call: Call): Money {
        return if (call.from.hour >= NightlyDiscountPhone.LATE_NIGHT_HOUR) {
            val value = call.getDuration().seconds / seconds.seconds
            amount.times(value.toDouble())
        } else {
            val value = call.getDuration().seconds / seconds.seconds
            amount.times(value.toDouble())
        }
    }

    companion object {
        const val LATE_NIGHT_HOUR = 22
    }
}