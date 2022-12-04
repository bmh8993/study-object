package ch2.DiscountPolicy

import ch2.Money
import ch2.Screening

interface DiscountPolicy {
    fun calculateDiscountAmount(screening: Screening): Money
}