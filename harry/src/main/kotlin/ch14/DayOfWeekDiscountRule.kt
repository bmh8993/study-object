package ch14

import java.time.DayOfWeek
import java.time.Duration

class DayOfWeekDiscountRule(
    private val dayOfWeek: List<DayOfWeek>,
    private val duration: Duration,
    private val amount: Money
) {
    fun calculate(interval: DateTimeInterval): Money {
        if (dayOfWeek.contains(interval.from.dayOfWeek)) {
            return amount.times((interval.duration().seconds / duration.seconds).toDouble())
        }
        return Money.ZERO
    }
}