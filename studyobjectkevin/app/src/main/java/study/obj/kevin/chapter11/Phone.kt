package study.obj.kevin.chapter11
import java.time.Duration

abstract class Phone {
    private val calls = listOf<Call>()

    fun calculateFee(): Money {
        var result: Money = Money.ZERO
        calls.forEach {
            result = result.plus(calculateCallFee(it))
        }
        return afterCalculated(result)
    }

    abstract fun calculateCallFee(call: Call): Money
    abstract fun afterCalculated(fee: Money): Money
}

open class RegularPhone(
    private val amount: Money,
    private val seconds: Duration
): Phone() {

    override fun calculateCallFee(call: Call): Money {
        return amount.times(call.getDuration().seconds / seconds.seconds)
    }

    override fun afterCalculated(fee: Money): Money {
        return fee
    }
}

open class NightlyDiscountPhone(
    private val nightlyAmount: Money,
    private val regularAmount: Money,
    private val seconds: Duration
): Phone() {

    override fun calculateCallFee(call: Call): Money {
        if (call.getFrom().hour >= LATE_NIGHT_HOUR) {
            return nightlyAmount.times(call.getDuration().seconds / seconds.seconds)
        }
        return regularAmount.times(call.getDuration().seconds / seconds.seconds)
    }

    override fun afterCalculated(fee: Money): Money {
        return fee
    }

    companion object {
        const val LATE_NIGHT_HOUR = 22
    }
}

open class TaxableRegularPhone(
    private val amount: Money,
    private val seconds: Duration,
    private val taxRate: Double
): RegularPhone(amount, seconds) {
    override fun calculateCallFee(call: Call): Money {
        val fee = super.calculateCallFee(call)
        return fee.plus(fee.times(taxRate))
    }

    override fun afterCalculated(fee: Money): Money {
        return fee.plus(fee.times(taxRate))
    }
}

open class TaxableNightlyDiscountPhone(
    private val nightlyAmount: Money,
    private val regularAmount: Money,
    private val seconds: Duration,
    private val taxRate: Double
): NightlyDiscountPhone(
    nightlyAmount, regularAmount, seconds
) {
    override fun afterCalculated(fee: Money): Money {
        return fee.plus(fee.times(taxRate))
    }
}

open class RateDiscountableRegularPhone(
    private val amount: Money,
    private val seconds: Duration,
    private val discountAmount: Money
) : RegularPhone(
    amount, seconds
) {
    override fun afterCalculated(fee: Money): Money {
        return fee.minus(discountAmount)
    }
}

open class RateDiscountableNightlyDiscountPhone(
    private val nightlyAmount: Money,
    private val regularAmount: Money,
    private val seconds: Duration,
    private val discountAmount: Money
): NightlyDiscountPhone(
    nightlyAmount, regularAmount, seconds
) {
    override fun afterCalculated(fee: Money): Money {
        return fee.minus(discountAmount)
    }
}

class TaxableAndRateDiscountableRegularPhone(
    private val amount: Money,
    private val seconds: Duration,
    private val taxRate: Double,
    private val discountAmount: Money
): TaxableRegularPhone(
    amount, seconds, taxRate
) {
    override fun afterCalculated(fee: Money): Money {
        return super.afterCalculated(fee).minus(discountAmount)
    }
}

class RateDiscountableAndTaxableRegularPhone(
    private val amount: Money,
    private val seconds: Duration,
    private val discountAmount: Money,
    private val taxRate: Double,
): RateDiscountableRegularPhone(
    amount, seconds, discountAmount
) {
    override fun afterCalculated(fee: Money): Money {
        return super.afterCalculated(fee).plus(fee.times(taxRate))
    }
}

class TaxableAndDiscountableNightlyDiscountPhone(
    private val nightlyAmount: Money,
    private val regularAmount: Money,
    private val seconds: Duration,
    private val taxRate: Double,
    private val discountAmount: Money
): TaxableNightlyDiscountPhone(
    nightlyAmount, regularAmount, seconds, taxRate
) {
    override fun afterCalculated(fee: Money): Money {
        return super.afterCalculated(fee).minus(discountAmount)
    }
}

class RateDiscountableAndTaxableNightlyDiscountPhone(
    private val nightlyAmount: Money,
    private val regularAmount: Money,
    private val seconds: Duration,
    private val discountAmount: Money,
    private val taxRate: Double

): RateDiscountableNightlyDiscountPhone(
    nightlyAmount, regularAmount, seconds, discountAmount
) {
    override fun afterCalculated(fee: Money): Money {
        return super.afterCalculated(fee).plus(fee.times(taxRate))
    }
}

