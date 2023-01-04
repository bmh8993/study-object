package _05_movie_rdd

import java.time.Duration

class AmountDiscountMovie(
    private val title: String,
    private val runningTime: Duration,
    override val fee: Money,
    private val discountAmount: Money,
    private val discountConditions: List<DiscountCondition>
) : Movie(title, runningTime, fee, discountConditions) {

    override fun calculateDiscountAmount(): Money {
        return discountAmount
    }
}
