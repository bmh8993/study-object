package _11_composition.additionalratepolicy

import _11_composition.Money
import _11_composition.RatePolicy

class TaxablePolicy(
    private val taxRatio: Double,
    override val next: RatePolicy
) : AdditionalRatePolicy(next) {

    override fun afterCalculated(fee: Money): Money {
        return fee.plus(fee.times(taxRatio))
    }
}