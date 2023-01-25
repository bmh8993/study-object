package study.obj.kevin.chapter11

import java.time.Duration

abstract class BasicRatePolicy: RatePolicy {
    override fun calculateFee(phone: Phone): Money {
        var result: Money = Money.ZERO
        phone.getCall().forEach {
            result.plus(calculateCallFee(it))
        }
        return result
    }

    abstract fun calculateCallFee(call: Call): Money
}

class RegularPolicy(
    private val amount: Money,
    private val seconds: Duration
): BasicRatePolicy() {
    override fun calculateCallFee(call: Call): Money {
        return amount.times(call.getDuration().seconds / seconds.seconds)
    }
}

class NightlyDiscountPolicy(
    private val nightlyAmount: Money,
    private val regularAmount: Money,
    private val seconds: Duration

): BasicRatePolicy() {

    override fun calculateCallFee(call: Call): Money {
        if (call.getFrom().hour >= LATE_NIGHT_HOUR) {
            return nightlyAmount.times(call.getDuration().seconds / seconds.seconds)
        }
        return regularAmount.times(call.getDuration().seconds / seconds.seconds)

    }

    companion object {
        const val LATE_NIGHT_HOUR = 22
    }
}