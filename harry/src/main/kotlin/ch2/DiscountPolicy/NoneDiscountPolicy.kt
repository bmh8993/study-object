package ch2.DiscountPolicy

import ch2.DiscountCondition.DiscountCondition
import ch2.Money
import ch2.Screening

class NoneDiscountPolicy : DiscountPolicy {

    override fun calculateDiscountAmount(screening: Screening): Money {
        return Money.ZERO
    }
}