package ch5

import java.time.Duration

class AmountDiscountMovie constructor(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private val discountConditions: List<DiscountCondition>,
    private val discountAmount: Money
) : Movie(title, runningTime, fee, discountConditions) {

    override fun calculateDiscountAmount(): Money {
        return discountAmount
    }
}