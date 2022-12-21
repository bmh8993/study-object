package _04_movie_data_intensive

import java.time.Duration

// kotlin에서 propery를 쓰면 private가 아닌 이상 getter/setter가 만들어진다.
// OOP 측면에서 게터 세터를 지양하고 다른 함수나 커스텀 프로퍼티 등으로 대체하자.
// setter 노출은 최대한 자제하는게 좋은 것 같다.
class Movie(
    _title: String,
    _runningTime: Duration,
    _fee: Money,
    _discountConditions: List<DiscountCondition>
) {
    var title = _title
        private set
    var runningTime = _runningTime
        private set
    var fee = _fee
        private set
    var discountConditions = _discountConditions
        private set
    var movieType: MovieType = MovieType.NONE_DISCOUNT
        private set
    var discountAmount: Money = Money.ZERO
        private set
    var discountPercent: Double = 0.0
        private set

    fun changeTitle(title: String) {
        this.title = title
    }

    fun changeRunningTime(runningTime: Duration) {
        this.runningTime = runningTime
    }

    fun changeFee(fee: Money) {
        this.fee = fee
    }

    fun changeDiscountConditions(discountConditions: List<DiscountCondition>) {
        this.discountConditions = discountConditions
    }

    fun changeMovieType(movieType: MovieType) {
        this.movieType = movieType
    }

    fun changeDiscountAmount(discountAmount: Money) {
        this.discountAmount = discountAmount
    }

    fun changeDiscountPercent(discountPercent: Double) {
        this.discountPercent = discountPercent
    }
}
