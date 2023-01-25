package ch12

open class Lecture(
    private val pass: Int,
    private val title: String,
    private val scores: List<Int>
) {
    fun average(): Double {
        return scores.average()
    }

    fun getScores(): List<Int> {
        return scores
    }

    open fun evaluate(): String {
        return "pass:${passCount()} Fail:${failCount()}"
    }

    fun passCount(): Long {
        return scores.count { it >= pass }.toLong()
    }

    fun failCount(): Long {
        return scores.size - passCount()
    }

    fun stats(): String {
        return "title:${title}, Evaluation Method: ${getEvaluationMethod()}"
    }

    open fun getEvaluationMethod(): String {
        return "Pass or Fail"
    }
}