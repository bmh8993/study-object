package ch10

import java.time.Duration

class RegularPhone(
    val amount: Money,
    val seconds: Duration = Duration.ZERO,
    override var calls: List<Call>,
    override val taxRate: Double
) : Phone(calls, taxRate) {

    override fun calculateCallFee(call: Call): Money {
        val value = call.getDuration().seconds / seconds.seconds
        return amount.times(value.toDouble())
    }
}