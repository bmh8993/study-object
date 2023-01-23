package ch10

abstract class Phone(open val calls: List<Call>, open val taxRate: Double) {
    fun calculateFee(): Money {
        var result = Money.ZERO

        calls.forEach {
            result = result.plus(calculateCallFee(it))
        }

        return result.plus(result.times(taxRate))
    }

    abstract fun calculateCallFee(call: Call): Money
}