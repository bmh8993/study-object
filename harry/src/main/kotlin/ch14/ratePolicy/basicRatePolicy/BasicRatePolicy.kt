package ch14.ratePolicy.basicRatePolicy

import ch14.Call
import ch14.FeeRule
import ch14.Money
import ch14.Phone
import ch14.ratePolicy.RatePolicy

class BasicRatePolicy(private val feeRules: List<FeeRule>) : RatePolicy {

    override fun calculateFee(phone: Phone): Money {
        var result = Money.ZERO

        phone.getCalls().map { calculate(it) }.reduce { acc, money -> acc.plus(money) }
        return result
    }

    private fun calculate(call: Call): Money {
        return feeRules.map { it.calculateFee(call) }.reduce { acc, money -> acc.plus(money) }
    }
}