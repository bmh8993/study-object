package _04_movie_data_intensive

import java.time.DayOfWeek
import java.time.LocalTime

/**
 * 이 객체가 데이터에 대해 수행해야하는 오퍼레이션은 무엇인가?
 * type에 따라 할인 조건을 판단하는 방법이 다르다. 할인 조건을 판단할 수 있는 isDiscountable 메서드가 필요하다.
 */
class DiscountCondition(
    val type: DiscountConditionType,
    private val sequence: Int,
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime
) {

    fun isDiscountable(dayOfWeek: DayOfWeek, time: LocalTime): Boolean {
        if (this.type != DiscountConditionType.PERIOD) throw IllegalArgumentException()

        return this.dayOfWeek == dayOfWeek &&
            this.startTime <= time &&
            this.endTime >= time
    }

    fun isDiscountable(sequence: Int): Boolean {
        if (this.type != DiscountConditionType.SEQUENCE) throw IllegalArgumentException()

        return this.sequence == sequence
    }
}
