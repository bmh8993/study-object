package _02_movie

/**
 * 책임의 위치를 결정하기 위해 조건문을 사용하는 것은 협력의 설계 측변에서 좋은 선택이 아님
 * 항상 예외 케이스를 최소화 하고 일관성을 유지할 수 있는 방법을 선택하라
 */
class NoneDiscountPolicy : DiscountPolicy {
    /**
     * 리팩토링 이전 DiscountPolicy의 getDiscountAmount를 사용하고 있는데,
     * 이는 개발자가 DiscountPolicy의 getDiscountAmount가 호출되지 않을 경우(conditions가 없을 경우) DiscountPolicy가 0원을 반환할 것이라는 사실을 알고 있기 때문이다.
     */
    override fun calculateDiscountAmount(screening: Screening): Money {
        return Money.ZERO
    }
}
