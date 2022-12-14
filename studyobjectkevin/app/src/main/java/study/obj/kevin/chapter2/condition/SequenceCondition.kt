package study.obj.kevin.chapter2.condition

import study.obj.kevin.chapter2.Screening
import study.obj.kevin.chapter2.policy.DiscountCondition

class SequenceCondition constructor(private val sequence: Int): DiscountCondition {
    override fun isSatisfiedBy(screening: Screening) = screening.isSequence(sequence)
}