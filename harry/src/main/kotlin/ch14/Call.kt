package ch14

import java.time.Duration
import java.time.LocalDateTime

class Call(val interval: DateTimeInterval) {
    fun getDuration() = interval.duration()

    fun getFrom() = interval.from

    fun getTo() = interval.to

    fun splitByDay(): List<DateTimeInterval> {
        return interval.splitByDay()
    }
}