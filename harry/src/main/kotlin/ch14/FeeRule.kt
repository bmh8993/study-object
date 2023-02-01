package ch14

import ch14.feeCondition.FeeCondition

class FeeRule(
    private val feeCondition: FeeCondition,
    private val feePerDuration: FeePerDuration
) {

    fun calculateFee(call: Call): Money {
        return feeCondition.findTimeIntervals(call).map { feePerDuration.calculate(it) }
            .reduce { total, num -> total.plus(num) }
    }
}