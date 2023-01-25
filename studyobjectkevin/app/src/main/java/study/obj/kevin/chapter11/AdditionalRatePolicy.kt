package study.obj.kevin.chapter11

abstract class AdditionalRatePolicy(
    private val next: RatePolicy
): RatePolicy {

    override fun calculateFee(phone: Phone): Money {
        var fee = next.calculateFee(phone)
        return afterCalculated(fee)
    }

    abstract fun afterCalculated(fee: Money): Money
}

class TaxablePolicy(
    private val taxRatio: Double,
    private val next:RatePolicy
): AdditionalRatePolicy(
    next
) {
    override fun afterCalculated(fee: Money): Money {
        return fee.plus(fee.times(taxRatio))
    }
}

class RateDiscountablePolicy(
    private val discountAmount: Money,
    private val next:RatePolicy
): AdditionalRatePolicy(next) {
    override fun afterCalculated(fee: Money): Money {
        return fee.minus(discountAmount)
    }
}