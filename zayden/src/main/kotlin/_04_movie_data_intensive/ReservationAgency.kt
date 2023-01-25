package _04_movie_data_intensive

class ReservationAgency {

    fun reserve(
        screening: Screening,
        customer: Customer,
        audienceCount: Int
    ): Reservation {
        val fee = screening.calculateFee(audienceCount)
        return Reservation(customer, screening, fee, audienceCount)
    }
}
