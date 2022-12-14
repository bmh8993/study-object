package _02_movie

import java.time.Duration

class Movie(
    private val title: String,
    private val runningTime: Duration,
    val fee: Money,
    private var discountPolicy: DiscountPolicy
) {

    fun calculateMovieFee(screening: Screening): Money {
        return this.fee.minus(discountPolicy.calculateDiscountAmount(screening))
    }

    /**
     * 정의된 메시지를 통해서만 코드를 재사용하는 방법이 합성이다.
     * 또한, 합성은 다른 객체의 인스턴스를 자신의 인스턴스 변수로 포함해서 재상요하는 방법을 말한다.
     * 여기서 discountPolicy를 changeDiscountPolicy라는 메시지로 변경할 수 있도록한다.
     */
    fun changeDiscountPolicy(discountPolicy: DiscountPolicy) {
        this.discountPolicy = discountPolicy
    }
}
