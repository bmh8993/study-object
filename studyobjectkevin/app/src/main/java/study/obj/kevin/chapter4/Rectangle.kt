package study.obj.kevin.chapter4

class Rectangle constructor(var left: Int, var top: Int, var right: Int, var bottom: Int) {
    fun enlarge(multiple: Int) {
        right *= multiple
        bottom *= multiple
    }
}