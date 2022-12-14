package study.obj.kevin.chapter1

import java.time.LocalDateTime

//이벤트 당첨자  -> 초대장을 티켓으로 교환
//이벤트 미당첨자 -> 티켓을 구매 함

//초대장
class Invitation {
    private lateinit var whenTime: LocalDateTime
}