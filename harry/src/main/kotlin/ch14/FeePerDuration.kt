package ch14

import java.time.Duration
import kotlin.math.ceil

class FeePerDuration(
    private val fee: Money,
    private val duration: Duration
) {
    fun calculate(interval: DateTimeInterval): Money {
        return fee.times(ceil((interval.duration().nano).toDouble() / duration.toNanos()))
    }
}