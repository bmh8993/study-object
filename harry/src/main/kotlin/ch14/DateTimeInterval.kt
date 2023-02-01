package ch14

import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class DateTimeInterval(
    val from: LocalDateTime,
    val to: LocalDateTime
) {
    fun duration(): Duration {
        return Duration.between(from, to)
    }

    fun splitByDay(): List<DateTimeInterval> {
        if (days() > 0) {
            return splitByDay(days())
        }
        return listOf(this)
    }

    private fun days(): Long {
        return Duration.between(from.toLocalDate().atStartOfDay(), to.toLocalDate().atStartOfDay()).toDays()
    }

    private fun splitByDay(days: Long): List<DateTimeInterval> {
        val result = mutableListOf<DateTimeInterval>()
        addFirstDay(result)
        addMiddleDays(result, days)
        addLastDay(result)
        return result.toList()
    }

    private fun addFirstDay(result: MutableList<DateTimeInterval>) {
        result.add(DateTimeInterval.toMidnight(from))
    }

    private fun addMiddleDays(result: MutableList<DateTimeInterval>, days: Long) {
        repeat(days.toInt()) {
            result.add(DateTimeInterval.during(from.toLocalDate().plusDays(it.toLong())))
        }
    }

    private fun addLastDay(result: MutableList<DateTimeInterval>) {
        result.add(DateTimeInterval.fromMidnight(to))
    }


    companion object {
        fun toMidnight(from: LocalDateTime): DateTimeInterval {
            return DateTimeInterval(from, LocalDateTime.of(from.toLocalDate(), LocalTime.of(23, 59, 59, 999_999_999)))
        }

        fun fromMidnight(to: LocalDateTime): DateTimeInterval {
            return DateTimeInterval(LocalDateTime.of(to.toLocalDate(), LocalTime.of(0, 0)), to)
        }

        fun during(date: LocalDate): DateTimeInterval {
            return DateTimeInterval(
                LocalDateTime.of(date, LocalTime.of(0, 0)),
                LocalDateTime.of(date, LocalTime.of(23, 59, 59, 999_999_999))
            )
        }
    }
}

