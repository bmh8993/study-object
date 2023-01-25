package ch11

abstract class AdditionalRatePolicy(
    private val next: RatePolicy
) : RatePolicy {
    override fun calculateFee(phone: Phone): Money {
        val fee = next.calculateFee(phone)
        return afterCalculated(fee)
    }

    protected abstract fun afterCalculated(fee: Money): Money
}