package _04_movie_data_intensive

class Reservation(
    private val customer: Customer,
    private val screening: Screening,
    private val fee: Money,
    private val audienceCount: Int
)
