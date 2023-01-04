package ch5

interface DiscountCondition {
    fun isSatisfiedBy(screening: Screening): Boolean
}