package _10_call

import java.time.Duration
import java.time.LocalDateTime

class Call(
    val from: LocalDateTime,
    val to: LocalDateTime
) {
    val duration: Duration = Duration.between(this.from, this.to)
}
