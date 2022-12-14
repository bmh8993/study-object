package _02_movie

interface DiscountPolicy {
    fun calculateDiscountAmount(screening: Screening): Money
}
