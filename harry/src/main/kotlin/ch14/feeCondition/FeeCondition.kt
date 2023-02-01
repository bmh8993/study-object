package ch14.feeCondition

import ch14.Call
import ch14.DateTimeInterval

interface FeeCondition {
    fun findTimeIntervals(call: Call): List<DateTimeInterval>
}