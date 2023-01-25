package ch12

class Professor constructor(
    private val name: String,
    private val lecture: Lecture
) {
    fun compileStatistics(): String {
        return "$name ${lecture.evaluate()} ${lecture.average()}"
    }
}