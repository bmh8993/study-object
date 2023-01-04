1. message: 예매하라 
   - from: ?
   - to: Screening
2. message: 가격을 계산하라
   - from: Screening
   - to: Movie
3. message: 할인 여부를 판단하라
   - from: Movie
   - to: DiscountCondition
4. create Reservation
   - from: Screening

- Screening: 영화를 예매할 책임이 있다. 그 결과로 Reservation 인스턴스를 생성한다.(Creator)
