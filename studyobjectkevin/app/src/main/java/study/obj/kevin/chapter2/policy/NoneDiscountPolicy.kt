package study.obj.kevin.chapter2.policy

import study.obj.kevin.chapter2.Money
import study.obj.kevin.chapter2.Screening

class NoneDiscountPolicy: DiscountPolicy {
    override fun calculateDiscountAmount(screening: Screening): Money {
        return Money.ZERO
    }
}