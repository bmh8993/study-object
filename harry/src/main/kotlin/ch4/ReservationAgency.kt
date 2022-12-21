package ch4

class ReservationAgency {
    fun reserve(screening: Screening, customer: Customer, audienceCount: Int): Reservation {
        val movie = screening.movie
        val discountable = movie.isDiscountable(screening.whenScreened, screening.sequence)

//        for (condition in movie.discountConditions) {
//            discountable = if (condition.type == DiscountConditionType.PERIOD) {
//                val validScreened = screening.whenScreened.dayOfWeek == condition.dayOfWeek
//                val validStartTime = condition.startTime <= screening.whenScreened.toLocalTime()
//                val validEndTime = condition.endTime >= screening.whenScreened.toLocalTime()
//                validScreened && validStartTime && validEndTime
//            } else {
//                condition.sequence == screening.sequence
//            }
//
//            if(discountable) break
//        }

        val fee = if(discountable) {
            screening.calculateFee(audienceCount)
        } else {
            movie.fee
        }

//        val fee = if(discountable) {
//            val discountAmount = when(movie.movieType) {
//                MovieType.AMOUNT_DISCOUNT -> movie.discountAmount
//                MovieType.PERCENT_DISCOUNT -> movie.fee.times(movie.discountPercent)
//                MovieType.NONE_DISCOUNT -> Money.ZERO
//            }
//
//            movie.fee.minus(discountAmount)
//        } else {
//            movie.fee
//        }

        return Reservation(customer, screening, fee, audienceCount)
    }
}