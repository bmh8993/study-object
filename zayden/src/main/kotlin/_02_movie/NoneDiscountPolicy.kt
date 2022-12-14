package _02_movie

/**
 * 책임의 위치를 결정하기 위해 조건문을 사용하는 것은 협력의 설계 측변에서 좋은 선택이 아님
 * 항상 예외 케이스를 최소화 하고 일관성을 유지할 수 있는 방법을 선택하라
 */
class NoneDiscountPolicy : DiscountPolicy() {
    override fun getDiscountAmount(screening: Screening): Money {
        return Money.ZERO
    }
}
