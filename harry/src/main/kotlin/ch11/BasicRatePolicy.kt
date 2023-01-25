package ch11

abstract class BasicRatePolicy : RatePolicy {
    override fun calculateFee(phone: Phone): Money {
        var result = Money.ZERO

        phone.calls.forEach {
            result += result.plus(calculateCallFee(it))
        }

        return result
    }

    protected abstract fun calculateCallFee(call: Call): Money
}