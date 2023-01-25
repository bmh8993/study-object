package ch11

interface RatePolicy {
    fun calculateFee(phone: Phone): Money
}