package _04_movie_data_intensive

import java.time.DayOfWeek
import java.time.LocalTime

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
}
