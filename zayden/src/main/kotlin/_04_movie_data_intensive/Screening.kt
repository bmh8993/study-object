package _04_movie_data_intensive

import java.time.LocalDateTime

/**
 * 이 객체가 데이터에 대해 수행해야하는 오퍼레이션은 무엇인가?
 * 상영 시 요금을 계산 하는 메서드
 */
class Screening(
    private val movie: Movie,
    private val sequence: Int,
    private val whenScreened: LocalDateTime
) {
    fun calculateFee(audienceCount: Int): Money {
        when (movie.movieType) {
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
            MovieType.NONE_DISCOUNT -> {
                return movie.calculateNoneDiscountedFee().times(audienceCount.toDouble())
            }
        }

        return movie.calculateNoneDiscountedFee().times(audienceCount.toDouble())
    }
}
