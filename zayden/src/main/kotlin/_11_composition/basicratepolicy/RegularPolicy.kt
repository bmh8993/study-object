package _11_composition.basicratepolicy

import _11_composition.Call
import _11_composition.Money
import java.time.Duration

class RegularPolicy(
    private val amount: Money,
    private val seconds: Duration
) : BasicRatePolicy() {

    override fun calculateCallFee(call: Call): Money {
        return amount.times((call.duration.seconds / seconds.seconds).toDouble())
    }
}