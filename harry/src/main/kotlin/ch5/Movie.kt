package ch5

import java.time.Duration

enum class MovieType {
    AMOUNT_DISCOUNT,
    PERCENT_DISCOUNT,
    NONE_DISCOUNT
}

abstract class Movie constructor(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private val discountConditions: List<DiscountCondition>,
) {
    fun calculateMovieFee(screening: Screening): Money {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount())
        }
        return fee
    }

    private fun isDiscountable(screening: Screening): Boolean {
        return discountConditions.stream().anyMatch { condition -> condition.isSatisfiedBy(screening) }
    }

    protected abstract fun calculateDiscountAmount(): Money
}