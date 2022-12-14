package _02_movie

class AmountDiscountPolicy(
    private val discountAmount: Money,
    vararg conditions: DiscountCondition
) : DefaultDiscountPolicy(*conditions) {

    override fun getDiscountAmount(screening: Screening): Money {
        return discountAmount
    }
}
