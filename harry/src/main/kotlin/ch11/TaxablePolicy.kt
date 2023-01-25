package ch11

class TaxablePolicy(private val taxRatio: Double, next: RatePolicy) : AdditionalRatePolicy(next) {
    override fun afterCalculated(fee: Money): Money {
        return fee.plus(fee.times(taxRatio))
    }
}