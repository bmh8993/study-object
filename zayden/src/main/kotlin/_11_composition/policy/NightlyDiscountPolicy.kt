package _11_composition.policy

import _11_composition.Call
import _11_composition.Money
import java.time.Duration

class NightlyDiscountPolicy(
    private val nightlyAmount: Money,
    private val regularAmount: Money,
    private val seconds: Duration
) : BasicRatePolicy() {

    companion object {
        private val LATE_NIGHT_HOUR = 22
    }

    override fun calculateCallFee(call: Call): Money {
        if (call.from.hour >= LATE_NIGHT_HOUR) {
            return nightlyAmount.times((call.duration.seconds / seconds.seconds).toDouble())
        }

        return regularAmount.times((call.duration.seconds / seconds.seconds).toDouble())
    }
}