package _05_movie_rdd

import java.time.Duration

abstract class Movie(
    private val title: String,
    private val runningTime: Duration,
    protected open val fee: Money,
    private val discountConditions: List<DiscountCondition>
) {

    fun calculateMovieFee(screening: Screening): Money {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount())
        }

        return fee
    }

    abstract fun calculateDiscountAmount(): Money

    private fun isDiscountable(screening: Screening): Boolean {
        for (discountCondition in discountConditions) {
            if (discountCondition.isSatisfiedBy(screening)) {
                return true
            }
        }

        return false
    }
}
