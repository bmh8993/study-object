package ch2.DiscountPolicy

import ch2.Money
import ch2.Screening
import ch2.DiscountCondition.DiscountCondition

abstract class DefaultDiscountPolicy(
    private val conditions: List<DiscountCondition>
): DiscountPolicy {

    override fun calculateDiscountAmount(screening: Screening): Money {
        for (condition in conditions) {
            if (condition.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening)
            }
        }

        return Money.ZERO
    }

    protected abstract fun getDiscountAmount(screening: Screening): Money
}