package ch14.ratePolicy.additionalRatePolicy

import ch14.Money
import ch14.ratePolicy.RatePolicy

class RateDiscountablePolicy(
    private val discountAmount: Money,
    private val next: RatePolicy
) : AdditionalRatePolicy(next) {

    override fun afterCalculated(fee: Money): Money {
        return fee.minus(discountAmount)
    }
}