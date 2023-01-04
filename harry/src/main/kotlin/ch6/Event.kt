package ch6

import java.time.Duration
import java.time.LocalDateTime

class Event constructor(
    private val subject: String,
    private var from: LocalDateTime,
    private var duration: Duration
) {

    fun isSatisfied(schedule: RecurringSchedule): Boolean {
        return !(from.dayOfWeek != schedule.dayOfWeek || !from.toLocalTime().equals(schedule.from) || duration != schedule.duration)
    }

    fun reschedule(schedule: RecurringSchedule) {
        from = LocalDateTime.of(from.toLocalDate().plusDays(daysDistance(schedule).toLong()), schedule.from)
        duration = schedule.duration
    }

    private fun daysDistance(schedule: RecurringSchedule): Int {
        return schedule.dayOfWeek.value - from.dayOfWeek.value
    }
}