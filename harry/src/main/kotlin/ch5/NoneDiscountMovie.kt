package ch5

import java.time.Duration

class NoneDiscountMovie constructor(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private val discountConditions: List<DiscountCondition>,
) : Movie(title, runningTime, fee, discountConditions) {
    override fun calculateDiscountAmount(): Money {
        return Money.ZERO
    }
}