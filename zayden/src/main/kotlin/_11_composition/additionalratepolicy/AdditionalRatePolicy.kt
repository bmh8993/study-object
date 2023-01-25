package _11_composition.additionalratepolicy

import _11_composition.Money
import _11_composition.Phone
import _11_composition.RatePolicy

abstract class AdditionalRatePolicy(
    open val next: RatePolicy
) : RatePolicy {

    override fun calculateFee(phone: Phone): Money {
        val fee = next.calculateFee(phone)
        return afterCalculated(fee)
    }

    protected abstract fun afterCalculated(fee: Money): Money
}
