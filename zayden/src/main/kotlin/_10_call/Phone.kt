package _10_call

import java.time.Duration

class Phone(
    val amount: Money,
    val seconds: Duration
) {
    val calls: ArrayList<Call> = arrayListOf()

    fun call(call: Call) {
        calls.add(call)
    }

    fun calculateFee(): Money {
        var result = Money.ZERO

        for (call in calls) {
            result = result.plus(amount.times(call.duration.seconds.toDouble() / seconds.seconds))
        }

        return result
    }
}
