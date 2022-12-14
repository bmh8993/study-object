package study.obj.kevin.chapter2.policy

import study.obj.kevin.chapter2.Money
import study.obj.kevin.chapter2.Screening

class AmountDiscountPolicy(
    private val discountAmount: Money,
    conditions: List<DiscountCondition>
) : DefaultDiscountPolicy(conditions) {
    override fun getDiscountAmount(screening: Screening): Money = discountAmount
}