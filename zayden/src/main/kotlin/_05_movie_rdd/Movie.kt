package _05_movie_rdd

import java.time.Duration

class Movie(
    private val title: String,
    private val runningTime: Duration,
    val fee: Money,
    private val discountConditions: List<DiscountCondition>
) {
    var movieType: MovieType = MovieType.NONE_DISCOUNT
        private set
    var discountAmount: Money = Money.ZERO
        private set
    var discountPercent: Double = 0.0
        private set

    fun calculateMovieFee(screening: Screening): Money {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount())
        }

        return fee
    }

    private fun calculateDiscountAmount(): Money {
        return when (movieType) {
            MovieType.AMOUNT_DISCOUNT -> calculateAmountDiscountAmount()
            MovieType.PERCENT_DISCOUNT -> calculatePercentDiscountAmount()
            MovieType.NONE_DISCOUNT -> calculateNoneDiscountAmount()
        }
    }

    private fun calculateNoneDiscountAmount(): Money {
        return Money.ZERO
    }

    private fun calculatePercentDiscountAmount(): Money {
        return fee.times(discountPercent)
    }

    private fun calculateAmountDiscountAmount(): Money {
        return discountAmount
    }

    private fun isDiscountable(screening: Screening): Boolean {
        for (discountCondition in discountConditions) {
            if (discountCondition.isSatisfiedBy(screening)) {
                return true
            }
        }

        return false
    }
}
