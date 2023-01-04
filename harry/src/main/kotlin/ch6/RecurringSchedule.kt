package ch6

import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalTime
import javax.security.auth.Subject

class RecurringSchedule constructor(
    val subject: Subject,
    val dayOfWeek: DayOfWeek,
    val from: LocalTime,
    val duration: Duration
) {
}