package _10_call

import java.time.Duration

class NightlyDiscountPhone(
    private val nightlyAmount: Money, // 10시 이후 적용
    private val regularAmount: Money, // 10시 이전 적용
    private val seconds: Duration,
    override val taxRate: Double
) : Phone(taxRate) {
    companion object {
        private const val LATE_NIGHT_HOUR = 22
    }

    override fun calculateCallFee(call: Call): Money {
        return if (call.from.hour >= LATE_NIGHT_HOUR) {
            nightlyAmount.times(call.duration.seconds.toDouble() / seconds.seconds)
        } else {
            regularAmount.times(call.duration.seconds.toDouble() / seconds.seconds)
        }
    }
}
