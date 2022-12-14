package _02_movie

abstract class DefaultDiscountPolicy(
    vararg conditions: DiscountCondition
) : DiscountPolicy {

    private var conditions: List<DiscountCondition> = ArrayList()

    init {
        this.conditions = conditions.toList()
    }

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
