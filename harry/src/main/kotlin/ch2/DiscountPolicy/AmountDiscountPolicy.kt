package ch2.DiscountPolicy

import ch2.Money
import ch2.Screening
import ch2.DiscountCondition.DiscountCondition

class AmountDiscountPolicy(
    private val discountAmount: Money,
    private val conditions: List<DiscountCondition>
) : DefaultDiscountPolicy(conditions) {

    override fun getDiscountAmount(screening: Screening): Money = discountAmount
}