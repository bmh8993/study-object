package ch14.feeCondition

import ch14.Call
import ch14.DateTimeInterval
import java.time.DayOfWeek

class DayOfWeekFeeCondition(private val dayOfWeeks: List<DayOfWeek>) : FeeCondition {
    override fun findTimeIntervals(call: Call): List<DateTimeInterval> {
        return call.interval.splitByDay().filter { dayOfWeeks.contains(it.from.dayOfWeek) }.toList()
    }
}