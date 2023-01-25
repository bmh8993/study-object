package ch11

class RateDiscountablePolicy(
    private val discountAmount: Money,
    private val next: RatePolicy
) : AdditionalRatePolicy(next) {

    override fun afterCalculated(fee: Money): Money {
        return fee.minus(discountAmount)
    }
}