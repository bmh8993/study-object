package study.obj.kevin.chapter11

interface RatePolicy {
    fun calculateFee(phone: Phone): Money
}