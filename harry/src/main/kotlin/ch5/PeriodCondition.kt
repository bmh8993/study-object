package ch5

import java.time.DayOfWeek
import java.time.LocalTime

class PeriodCondition(
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime
) : DiscountCondition {

    override fun isSatisfiedBy(screening: Screening): Boolean {
        return screening.whenScreened.dayOfWeek.equals(dayOfWeek)
                && startTime <= screening.whenScreened.toLocalTime()
                && endTime >= screening.whenScreened.toLocalTime()
    }
}