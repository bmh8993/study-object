package _04_movie_data_intensive

import java.time.DayOfWeek
import java.time.LocalTime

/**
 * 이 객체가 데이터에 대해 수행해야하는 오퍼레이션은 무엇인가?
 * type에 따라 할인 조건을 판단하는 방법이 다르다. 할인 조건을 판단할 수 있는 isDiscountable 메서드가 필요하다.
 */
class DiscountCondition(
    _type: DiscountConditionType,
    _sequence: Int,
    _dayOfWeek: DayOfWeek,
    _startTime: LocalTime,
    _endTime: LocalTime
) {
    var type = _type
        private set
    var sequence = _sequence
        private set
    var dayOfWeek = _dayOfWeek
        private set
    var startTime = _startTime
        private set
    var endTime = _endTime
        private set

    fun changeType(type: DiscountConditionType) {
        this.type = type
    }

    fun changeSequence(sequence: Int) {
        this.sequence = sequence
    }

    fun changeDayOfWeek(dayOfWeek: DayOfWeek) {
        this.dayOfWeek = dayOfWeek
    }

    fun changeStartTime(startTime: LocalTime) {
        this.startTime = startTime
    }

    fun changeEndTime(endTime: LocalTime) {
        this.endTime
    }

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
