package _04_movie_data_intensive

class ReservationAgency {

    fun reserve(
        screening: Screening,
        customer: Customer,
        audienceCount: Int
    ): Reservation {
        val movie = screening.movie

        var discountable = false
        for (discountCondition in movie.discountConditions) {
            discountable = when (discountCondition.type) {
                DiscountConditionType.PERIOD -> {
                    discountCondition.dayOfWeek == screening.whenScreened.dayOfWeek &&
                        discountCondition.startTime <= screening.whenScreened.toLocalTime() &&
                        discountCondition.endTime >= screening.whenScreened.toLocalTime()
                }

                DiscountConditionType.SEQUENCE -> {
                    discountCondition.sequence == screening.sequence
                }
            }

            if (discountable) break
        }

        val fee: Money = when (discountable) {
            true -> {
                val discountAmount = when (movie.movieType) {
                    MovieType.AMOUNT_DISCOUNT -> movie.discountAmount
                    MovieType.PERCENT_DISCOUNT -> movie.fee.times(movie.discountPercent)
                    MovieType.NONE_DISCOUNT -> Money.ZERO
                }

                movie.fee.minus(discountAmount)
            }

            false -> movie.fee
        }

        return Reservation(customer, screening, fee, audienceCount)
    }
}
