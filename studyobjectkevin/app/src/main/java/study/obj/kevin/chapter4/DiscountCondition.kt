package study.obj.kevin.chapter4

import java.time.DayOfWeek
import java.time.LocalTime

class DiscountCondition {
    lateinit var discountConditionType: DiscountConditionType
    private var sequence: Int = 0
    private lateinit var dayOfWeek: DayOfWeek
    private lateinit var startTime: LocalTime
    private lateinit var endTime: LocalTime

    fun isDiscountable(dayOfWeek: DayOfWeek, time: LocalTime): Boolean {
        if (discountConditionType != DiscountConditionType.PERIOD) {
            throw IllegalArgumentException()
        }
        return this.dayOfWeek.equals(dayOfWeek) &&
                this.startTime <= time &&
                this.endTime >= time
    }

    fun isDiscountable(sequence: Int): Boolean{
        if (discountConditionType != DiscountConditionType.SEQUENCE)
            throw IllegalArgumentException()
        return this.sequence == sequence
    }

}

enum class DiscountConditionType {
    SEQUENCE,
    PERIOD
}
