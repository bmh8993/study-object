package _05_movie_rdd

import java.time.Duration

class PercentDiscountMovie(
    private val title: String,
    private val runningTime: Duration,
    override val fee: Money,
    private val percent: Double,
    private val discountConditions: List<DiscountCondition>
) : Movie(title, runningTime, fee, discountConditions) {

    override fun calculateDiscountAmount(): Money {
        return fee.times(percent)
    }
}
