package study.obj.kevin.chapter2.policy

import study.obj.kevin.chapter2.Money
import study.obj.kevin.chapter2.Screening

class PercentDiscountPolicy(
    private val percent: Double,
    conditions: List<DiscountCondition>
) : DefaultDiscountPolicy(conditions) {
    override fun getDiscountAmount(screening: Screening) = screening.getMovieFee().times(percent)
}