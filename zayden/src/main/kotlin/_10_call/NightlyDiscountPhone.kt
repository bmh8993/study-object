package _10_call

import java.time.Duration

class NightlyDiscountPhone(
    private val nightlyAmount: Money, // 10시 이후 적용
    private val regularAmount: Money, // 10시 이전 적용
    private val seconds: Duration
) {
    companion object {
        private const val LATE_NIGHT_HOUR = 22
    }

    private val calls: ArrayList<Call> = arrayListOf()

    fun call(call: Call) {
        calls.add(call)
    }

    fun calculateFee(): Money {
        var result = Money.ZERO

        for (call in calls) {
            if (call.from.hour >= LATE_NIGHT_HOUR) {
                result = result.plus(
                    nightlyAmount.times(call.duration.seconds.toDouble() / seconds.seconds)
                )
            } else {
                regularAmount.times(call.duration.seconds.toDouble() / seconds.seconds)
            }
        }

        return result
    }
}
