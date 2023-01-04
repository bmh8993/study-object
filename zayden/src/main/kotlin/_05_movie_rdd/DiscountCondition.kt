package _05_movie_rdd

import java.time.DayOfWeek
import java.time.LocalTime

class DiscountCondition(
    val type: DiscountConditionType,
    private val sequence: Int,
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime
) {
    fun isSatisfiedBy(screening: Screening): Boolean {
        if (type == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(screening)
        }
        return isSatisfiedBySequence(screening)
    }

    private fun isSatisfiedBySequence(screening: Screening): Boolean {
        return sequence == screening.sequence
    }

    private fun isSatisfiedByPeriod(screening: Screening): Boolean {
        return dayOfWeek == screening.whenScreened.dayOfWeek &&
            startTime <= screening.whenScreened.toLocalTime() &&
            endTime >= screening.whenScreened.toLocalTime()
    }
}
