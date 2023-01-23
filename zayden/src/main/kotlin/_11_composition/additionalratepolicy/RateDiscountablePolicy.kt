package _11_composition.additionalratepolicy

import _11_composition.Money
import _11_composition.RatePolicy

class RateDiscountablePolicy(
    private val discountAmount: Money,
    override val next: RatePolicy
) : AdditionalRatePolicy(next) {

    override fun afterCalculated(fee: Money): Money {
        return fee.minus(discountAmount)
    }
}
