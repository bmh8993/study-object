package _04_movie_data_intensive

class Reservation(
    _customer: Customer,
    _screening: Screening,
    _fee: Money,
    _audienceCount: Int
) {
    var customer = _customer
        private set
    var screening = _screening
        private set
    var fee = _fee
        private set
    var audienceCount = _audienceCount
        private set

    fun changeCustomer(customer: Customer) {
        this.customer = customer
    }

    fun changeScreening(screening: Screening) {
        this.screening = screening
    }

    fun changeFee(fee: Money) {
        this.fee = fee
    }

    fun changeAudienceCount(audienceCount: Int) {
        this.audienceCount = audienceCount
    }
}
