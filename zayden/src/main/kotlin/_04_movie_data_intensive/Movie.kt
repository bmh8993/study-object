package _04_movie_data_intensive

import java.time.Duration
import java.time.LocalDateTime

// kotlin에서 propery를 쓰면 private가 아닌 이상 getter/setter가 만들어진다.
// OOP 측면에서 게터 세터를 지양하고 다른 함수나 커스텀 프로퍼티 등으로 대체하자.
// setter 노출은 최대한 자제하는게 좋은 것 같다.

/**
 * 이 객체가 데이터에 대해 수행해야하는 오퍼레이션은 무엇인가?
 * 영화 요금을 계산하는 메서드, 할인 여부를 판단하는 메서드
 */
class Movie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private val discountConditions: List<DiscountCondition>
) {
    var movieType: MovieType = MovieType.NONE_DISCOUNT
        private set
    var discountAmount: Money = Money.ZERO
        private set
    var discountPercent: Double = 0.0
        private set

    fun changeMovieType(movieType: MovieType) {
        this.movieType = movieType
    }

    fun changeDiscountAmount(discountAmount: Money) {
        this.discountAmount = discountAmount
    }

    fun changeDiscountPercent(discountPercent: Double) {
        this.discountPercent = discountPercent
    }

    fun calculateAmountDiscountedFee(): Money {
        if (this.movieType != MovieType.AMOUNT_DISCOUNT) throw IllegalArgumentException()

        return fee.minus(discountAmount)
    }

    fun calculatePercentDiscountedFee(): Money {
        if (this.movieType != MovieType.PERCENT_DISCOUNT) throw IllegalArgumentException()

        return fee.minus(fee.times(discountPercent))
    }

    fun calculateNoneDiscountedFee(): Money {
        if (this.movieType != MovieType.NONE_DISCOUNT) throw IllegalArgumentException()

        return fee
    }

    fun isDiscountable(whenScreened: LocalDateTime, sequence: Int): Boolean {
        for (discountCondition in this.discountConditions) {
            when (discountCondition.type) {
                DiscountConditionType.PERIOD -> {
                    if (discountCondition.isDiscountable(
                            dayOfWeek = whenScreened.dayOfWeek,
                            time = whenScreened.toLocalTime()
                        )
                    ) return false
                }
                DiscountConditionType.SEQUENCE -> {
                    if (discountCondition.isDiscountable(sequence)) return true
                }
            }
        }

        return false
    }
}
