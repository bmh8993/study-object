package study.obj.kevin.chapter11

import java.math.BigDecimal
import java.time.Duration

class CreatePhoneUseCase {
    fun execute() {
        val phone1 = Phone(
            TaxablePolicy(0.05,
                RegularPolicy(Money(BigDecimal.TEN), Duration.ZERO)
            ),
            ArrayList<Call>()
        )
    }
}