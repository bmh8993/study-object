package ch14.ratePolicy.additionalRatePolicy

import ch14.Money
import ch14.ratePolicy.RatePolicy

class TaxablePolicy(private val taxRatio: Double, next: RatePolicy) : AdditionalRatePolicy(next) {
    override fun afterCalculated(fee: Money): Money {
        return fee.plus(fee.times(taxRatio))
    }
}