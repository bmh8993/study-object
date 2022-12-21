package ch4

import java.time.LocalDateTime

data class Screening(
    val movie: Movie,
    val sequence: Int,
    val whenScreened: LocalDateTime
) {
    fun calculateFee(audienceCount: Int): Money {
        when (movie.movieType) {
            MovieType.AMOUNT_DISCOUNT -> {
                if(movie.isDiscountable(whenScreened, sequence)) {
                    return movie.calculateAmountDiscountedFee().times(audienceCount.toDouble())
                }
            }
            MovieType.PERCENT_DISCOUNT -> {
                if(movie.isDiscountable(whenScreened, sequence)) {
                    return movie.calculatePercentDiscountedFee().times(audienceCount.toDouble())
                }
            }
            MovieType.NONE_DISCOUNT ->
                return movie.calculateNoneDiscountedFee().times(audienceCount.toDouble())
        }

        return movie.calculateNoneDiscountedFee().times(audienceCount.toDouble())
    }
}