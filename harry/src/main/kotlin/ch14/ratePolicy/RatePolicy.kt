package ch14.ratePolicy

import ch14.Money
import ch14.Phone

interface RatePolicy {
    fun calculateFee(phone: Phone): Money
}