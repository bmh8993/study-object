package study.obj.kevin.chapter2


import DiscountCondition
import study.obj.kevin.chapter2.policy.DiscountPolicy
import java.math.BigDecimal
import java.time.Duration
import java.time.LocalDateTime

class Screening constructor(
    private val movie: Movie,
    private val sequence: Int,
    private val whenScreened: LocalDateTime
) {

    fun reserve(customer: Customer, audienceCount: Int) = Reservation(customer, this, calculateFee(audienceCount), audienceCount)
    fun getStartTime() = whenScreened
    fun isSequence(sequence: Int) = this.sequence == sequence
    fun getMovieFee() = movie.getFee()
    private fun calculateFee(audienceCount: Int): Money = movie.calculateMovieFee(this).times(audienceCount.toDouble())
}

abstract class Movie(
    private val fee: Money,
    private val discountPolicy: DiscountPolicy,
    private val discountConditions: List<DiscountCondition>
) {

    fun calculateMovieFee(screening: Screening): Money {
        return if (isDiscountable(screening))
            fee.minus(discountPolicy.calculateDiscountAmount(screening))
        else fee
    }
    private fun isDiscountable(screening: Screening): Boolean {
        return discountConditions.stream().anyMatch { condition ->
            condition.isSatisfiedBy(screening)
        }
    }

    fun getFee() = fee
    fun times(audienceCount: Int) = Money

    protected abstract fun calculateDiscountAmount(): Money
}

class AmountDiscountMovie(
    title: String,
    runningTime: Duration,
    fee: Money,
    discountPolicy: DiscountPolicy,
    discountConditions: List<DiscountCondition>,
    private val discountAmount: Money
): Movie(fee, discountPolicy, discountConditions) {
    override fun calculateDiscountAmount(): Money {
        return discountAmount
    }
}



class Money(private val amount: BigDecimal) {

    fun plus(amount: Money) = Money(this.amount.add(amount.amount))
    fun minus(amount: Money) = Money(this.amount.subtract(amount.amount))
    fun times(percent: Double) = Money(this.amount.multiply(BigDecimal.valueOf(percent)))

    fun isLessThan(other: Money) = amount.compareTo(other.amount) <0
    fun isGreaterThanOrEqual(other: Money) = amount.compareTo(other.amount) >= 0

    companion object {
        val ZERO: Money = wons(0)
        fun wons(amount: Long) = Money(BigDecimal.valueOf(amount))
        fun wons(amount: Double) = Money(BigDecimal.valueOf(amount))
    }
}
