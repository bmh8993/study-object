package ch14.ratePolicy.additionalRatePolicy

import ch14.Money
import ch14.Phone
import ch14.ratePolicy.RatePolicy

abstract class AdditionalRatePolicy(
    private val next: RatePolicy
) : RatePolicy {
    override fun calculateFee(phone: Phone): Money {
        val fee = next.calculateFee(phone)
        return afterCalculated(fee)
    }

    protected abstract fun afterCalculated(fee: Money): Money
}