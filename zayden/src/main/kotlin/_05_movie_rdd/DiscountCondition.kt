package _05_movie_rdd

/**
 * 변경 전
 * DiscountCondition은 응집도가 매우 낮다.
 * 1. 객체의 모든 property를 초기화 하지 않는다. 즉, type에 따라 일부만 초기화한다.
 * 2. 특정 메서드는 특정 property만을 사용한다.
 */

abstract class DiscountCondition {
    abstract fun isSatisfiedBy(screening: Screening): Boolean
}
