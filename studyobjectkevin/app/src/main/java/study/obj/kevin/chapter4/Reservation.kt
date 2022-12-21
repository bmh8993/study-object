package study.obj.kevin.chapter4

import study.obj.kevin.chapter2.Money
import study.obj.kevin.chapter4.Customer

class Reservation constructor(
    var customer: Customer,
    var screening: Screening,
    var fee: Money,
    var audienceCount: Int
)