package ch10

import java.time.Duration

class NightlyDiscountPhone(
    val nightlyAmount: Money,
    val regularAmount: Money,
    val seconds: Duration,
    override val calls: List<Call>,
    override val taxRate: Double
) : Phone(calls, taxRate) {

    override fun calculateCallFee(call: Call): Money {
        return if (call.from.hour >= LATE_NIGHT_HOUR) {
            val value = call.getDuration().seconds / seconds.seconds
            nightlyAmount.times(value.toDouble())
        } else {
            val value = call.getDuration().seconds / seconds.seconds
            regularAmount.times(value.toDouble())
        }
    }

    companion object {
        const val LATE_NIGHT_HOUR = 22
    }
}