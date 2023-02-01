package ch14.feeCondition

import ch14.Call
import ch14.DateTimeInterval
import ch14.feeCondition.FeeCondition

class FixedFeeCondition : FeeCondition {

    override fun findTimeIntervals(call: Call): List<DateTimeInterval> {
        return listOf(call.interval)
    }
}