package _02_movie

abstract class DiscountCondition {
    abstract fun isSatisfiedBy(screening: Screening): Boolean
}
