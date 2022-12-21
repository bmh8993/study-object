package ch4

import java.time.DayOfWeek
import java.time.LocalTime

enum class DiscountConditionType {
    SEQUENCE,
    PERIOD
}

data class DiscountCondition(
    val type: DiscountConditionType,
    val sequence: Int,
    val dayOfWeek: DayOfWeek,
    val startTime: LocalTime,
    val endTime: LocalTime
) {
    //객체 스스로가 데이터를 판단할수 있도록 하기 위해 메소드 구현.
    fun isDiscountable(dayOfWeek: DayOfWeek, time: LocalTime): Boolean {
        if (type != DiscountConditionType.PERIOD)
            throw IllegalArgumentException()

        return this.dayOfWeek == dayOfWeek && this.startTime <= time && this.endTime >= time
    }

    fun isDiscountable(sequence: Int): Boolean {
        if (type != DiscountConditionType.SEQUENCE)
            throw throw IllegalArgumentException()

        return this.sequence == sequence
    }
}
