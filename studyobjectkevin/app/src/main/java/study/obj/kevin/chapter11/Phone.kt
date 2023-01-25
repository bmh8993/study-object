package study.obj.kevin.chapter11
import java.util.*
import kotlin.collections.ArrayList

class Phone(
    private val ratePolicy: RatePolicy,
    private val calls: ArrayList<Call>
){
    fun getCall() = Collections.unmodifiableList(calls)
    fun calculateFee() = ratePolicy.calculateFee(this)
}