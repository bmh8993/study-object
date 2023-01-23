package ch10

import java.time.Duration
import java.time.LocalDateTime

class Call(val from: LocalDateTime, val to: LocalDateTime) {

    fun getDuration(): Duration = Duration.between(from, to)
}