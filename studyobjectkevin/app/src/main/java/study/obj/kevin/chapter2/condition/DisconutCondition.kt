

import study.obj.kevin.chapter2.Screening

interface DiscountCondition {
    fun isSatisfiedBy(screening: Screening) : Boolean
}