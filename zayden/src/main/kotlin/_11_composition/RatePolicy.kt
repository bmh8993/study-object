package _11_composition

interface RatePolicy {
    fun calculateFee(phone: Phone): Money
}
