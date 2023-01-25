package _11_composition

abstract class Phone(
    private val ratePolicy: RatePolicy // 여기가 바로 합성! phone 내부에 RatePolicy에 대한 참조가 포함되어져 있다. 또한 타입이 RatePolicy 이다.
) {

    val calls: ArrayList<Call> = arrayListOf()

    fun calculateFee(): Money = ratePolicy.calculateFee(this)

    fun call(call: Call) = calls.add(call)
}
