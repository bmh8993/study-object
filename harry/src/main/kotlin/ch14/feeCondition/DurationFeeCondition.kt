package ch14.feeCondition

import ch14.Call
import ch14.DateTimeInterval
import java.time.Duration

class DurationFeeCondition(private val from: Duration, private val to: Duration) : FeeCondition {
    override fun findTimeIntervals(call: Call): List<DateTimeInterval> {
        if (call.interval.duration() < from) {
            return listOf()
        }

        val from = call.interval.from.plus(from)
        val to = if (call.interval.duration() > to) call.interval.from.plus(to) else call.interval.to

        return listOf(DateTimeInterval(from, to))
    }
}