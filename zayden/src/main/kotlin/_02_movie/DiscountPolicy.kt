package _02_movie

abstract class DiscountPolicy(vararg conditions: DiscountCondition) {

    private var conditions: List<DiscountCondition> = ArrayList()

    init {
        this.conditions = conditions.toList()
    }

    abstract fun getDiscountAmount(screening: Screening): Money

    fun calculateDiscountAmount(screening: Screening): Money {
        for (each in conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening)
            }
        }

        return Money.ZERO
    }
}
