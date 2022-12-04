package ch2.DiscountCondition

import ch2.Screening

interface DiscountCondition {
    fun isSatisfiedBy(screening: Screening): Boolean
}