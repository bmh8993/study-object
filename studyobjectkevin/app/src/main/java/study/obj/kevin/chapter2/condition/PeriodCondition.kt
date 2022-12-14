package study.obj.kevin.chapter2.condition

import study.obj.kevin.chapter2.Screening
import study.obj.kevin.chapter2.policy.DiscountCondition
import java.time.DayOfWeek
import java.time.LocalTime

class PeriodCondition constructor(
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime
): DiscountCondition {
    override fun isSatisfiedBy(screening: Screening)
    = screening.getStartTime().dayOfWeek.equals(dayOfWeek) &&
            startTime <= screening.getStartTime().toLocalTime() &&
            endTime >= screening.getStartTime().toLocalTime()
}