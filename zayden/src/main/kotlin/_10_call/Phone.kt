package _10_call

abstract class Phone(open val taxRate: Double) {

    private val calls: ArrayList<Call> = arrayListOf()

    fun calculateFee(): Money {
        var result = Money.ZERO

        for (call in calls) {
            result = result.plus(calculateCallFee(call))
        }

        return result.plus(result.times(taxRate))
    }

    fun call(call: Call) {
        calls.add(call)
    }

    abstract fun calculateCallFee(call: Call): Money
}
