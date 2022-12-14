package study.obj.kevin.chapter2.policy

import study.obj.kevin.chapter2.Money
import study.obj.kevin.chapter2.Screening

abstract class DefaultDiscountPolicy(private val conditions: List<DiscountCondition>): DiscountPolicy {
    override fun calculateDiscountAmount(screening: Screening): Money {
        for (each in conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening)
            }
        }
        return Money.ZERO
    }

    protected abstract fun getDiscountAmount(screening: Screening): Money
}