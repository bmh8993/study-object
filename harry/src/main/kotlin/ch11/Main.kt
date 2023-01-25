package ch11

import java.time.Duration

class Main {
    fun run() {
        val phone = Phone(TaxablePolicy(0.05, RegularPolicy(Money.ZERO, Duration.ZERO)))
    }
}