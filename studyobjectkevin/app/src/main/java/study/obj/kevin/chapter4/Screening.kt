package study.obj.kevin.chapter4

import study.obj.kevin.chapter2.Money
import java.time.LocalDateTime

class Screening constructor(
    var movie: Movie,
    var sequence: Int,
    var whenScreened: LocalDateTime
) {


    fun calculateFee(audienceCount: Int): Money {
        when(movie.movieType) {
            MovieType.AMOUNT_DISCOUNT -> {
                if (movie.isDiscountable(whenScreened, sequence)) {
                    return movie.calculateAmountDiscountedFee().times(audienceCount.toDouble())
                }
            }
            MovieType.PERCENT_DISCOUNT -> {
                if (movie.isDiscountable(whenScreened, sequence)) {
                    return movie.calculatePercentDiscountedFee().times(audienceCount.toDouble())
                }
            }
            else ->{}
        }
        return movie.calculateNoneDiscountedFee().times(audienceCount.toDouble())
    }

}