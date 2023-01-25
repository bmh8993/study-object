package ch12

class GradeLecture(
    private val name: String,
    private val pass: Int,
    private val scores: List<Int>,
    private val grades: List<Grade>
) : Lecture(pass, name, scores) {

    override fun evaluate(): String {
        return "${super.evaluate()}, ${gradesStatistics()}"
    }

    override fun getEvaluationMethod(): String {
        return "Grade"
    }

    private fun gradesStatistics(): String {
        return grades.map { format(it) }.joinToString { " " }
    }

    private fun format(grade: Grade): String {
        return "${grade.name}:${gradeCount(grade)}"
    }

    private fun gradeCount(grade: Grade): Long {
        return getScores().count { grade.include(it) }.toLong()
    }
}