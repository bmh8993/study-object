package study.obj.kevin.chapter4

import study.obj.kevin.chapter2.Money
import java.time.Duration
import java.time.LocalDateTime

class Movie constructor(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    val movieType: MovieType,
    val discountConditions: List<DiscountCondition>,
    private val discountAmount: Money,
    private val discountPercent: Double = 0.0
) {
    fun calculateAmountDiscountedFee(): Money {
        if (movieType != MovieType.AMOUNT_DISCOUNT)
            throw  java.lang.IllegalArgumentException()
        return fee.minus(discountAmount)
    }

    fun calculatePercentDiscountedFee(): Money {
        if (movieType != MovieType.PERCENT_DISCOUNT)
            throw java.lang.IllegalArgumentException()
        return fee.minus(fee.times(discountPercent))
    }


    fun calculateNoneDiscountedFee(): Money {
        if (movieType != MovieType.NONE_DISCOUNT)
            throw java.lang.IllegalArgumentException()
        return fee
    }

    fun isDiscountable(whenScreened: LocalDateTime, sequence: Int): Boolean {
        discountConditions.forEach { condition ->
            if (condition.discountConditionType == DiscountConditionType.PERIOD) {
                if (condition.isDiscountable(whenScreened.dayOfWeek, whenScreened.toLocalTime()))
                    return true
            } else {
                if (condition.isDiscountable(sequence)) {
                    return true
                }
            }
        }
        return false
    }

    fun calculateFee(audience: Int) {

    }
}

enum class MovieType {
    AMOUNT_DISCOUNT,
    PERCENT_DISCOUNT,
    NONE_DISCOUNT
}