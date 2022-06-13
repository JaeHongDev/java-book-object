package chapter2;

import java.time.Duration;

public class Movie
{
    private String title; //제목
    private Duration runningTime; // 상영시간
    private Money fee;  // 기본요금
    private DiscountPolicy discountPolicy; // 할인정책

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title          = title;
        this.runningTime    = runningTime;
        this.fee            = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee(){
        return fee;
    }
    // calculateMovieFee 메서드는 discountPolicy에 calculateDiscountAmount 메시지를 전송해 할인 요금을 반환 받음.
    // Movie는 기본 요금인 fee에서 반환된 할인 요금을 차감한다.
    public Money calculateMovieFee(Screening screening){
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

}
