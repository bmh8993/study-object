package _10_call

import java.time.Duration

class RegularPhone(
    private val amount: Money,
    private val seconds: Duration,
    override val taxRate: Double
) : Phone(taxRate) {

    override fun calculateCallFee(call: Call): Money {
        return this.amount.times(call.duration.seconds.toDouble() / seconds.seconds)
    }
}
