package _05_movie_rdd

class SequenceCondition(
    private val sequence: Int
) : DiscountCondition() {
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return screening.isSequence(sequence)
    }
}
