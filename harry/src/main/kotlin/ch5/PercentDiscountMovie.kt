package ch5

import java.time.Duration

class PercentDiscountMovie constructor(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private val discountConditions: List<DiscountCondition>,
    private val percent: Double
) : Movie(title, runningTime, fee, discountConditions) {

    override fun calculateDiscountAmount(): Money {
        return fee.times(percent)
    }
}