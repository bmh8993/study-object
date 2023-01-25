package study.obj.kevin.chapter12

import java.util.Collections

abstract class Lecture(
    private val pass: Int,
    private val title: String,
    private val scores: ArrayList<Int>
) {
    fun average():Double {
        return scores.stream().mapToInt(Int::toInt).average().orElse(0.0)
    }
    fun getScores() = Collections.unmodifiableList(scores)
    open fun evaluate() = String.format("Pass:${passCount()} Fail:${failCount()}")
    fun passCount():Long = scores.stream().filter { score-> score>= pass}.count()
    fun failCount():Long = scores.size - passCount()
}

class GradeLecture(
    private val grades: ArrayList<Grade>,
    private val name: String,
    private val pass: Int,
    private val scores: ArrayList<Int>
): Lecture(pass, name, scores) {
    override fun evaluate(): String {
        return super.evaluate() + ", " + gradeStatistics()
    }
    private fun gradeStatistics() = grades.stream().map {
        grade -> format(grade)
    }
    private fun format(grade: Grade) = String.format("%s:%d", grade.getName(), gradeCount(grade))
    private fun gradeCount(grade: Grade) = getScores().stream().filter(grade::include).count()
    fun average(gradeName: String) = grades.stream().filter {
        grade -> grade.isName(gradeName)
    }.findFirst().map(this::gradeAverage).orElse(0.0)

    fun gradeAverage(grade: Grade) = getScores().stream().filter(grade::include).mapToInt(Int::toInt).average().orElse(
        0.0
    )
}

class Grade(
    private val name: String,
    private val upper: Int,
    private val lower: Int
) {
    fun getName() = name
    fun isName(name: String) = this.name == name
    fun include(score: Int) = score in lower..upper
}