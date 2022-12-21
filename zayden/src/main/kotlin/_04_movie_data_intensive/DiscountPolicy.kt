package _04_movie_data_intensive

interface DiscountPolicy {
    fun calculateDiscountAmount(screening: Screening): Money
}
