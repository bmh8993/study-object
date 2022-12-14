package study.obj.kevin.chapter2.policy

import study.obj.kevin.chapter2.Money
import study.obj.kevin.chapter2.Screening

interface DiscountPolicy {
    fun calculateDiscountAmount(screening: Screening): Money
}