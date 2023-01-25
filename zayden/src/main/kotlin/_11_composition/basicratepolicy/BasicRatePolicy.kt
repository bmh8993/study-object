package _11_composition.basicratepolicy

import _11_composition.Call
import _11_composition.Money
import _11_composition.Phone
import _11_composition.RatePolicy

abstract class BasicRatePolicy : RatePolicy {

    override fun calculateFee(phone: Phone): Money {
        val result = Money.ZERO

        for (call in phone.calls) {
            result.plus(calculateCallFee(call))
        }

        return result
    }

    protected abstract fun calculateCallFee(call: Call): Money
}
