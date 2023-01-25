package study.obj.kevin.chapter11

import java.time.Duration
import java.time.LocalDateTime

class Call(
    private val from: LocalDateTime,
    private val to: LocalDateTime
) {
    fun getDuration() = Duration.between(from, to)
    fun getFrom() = from

}