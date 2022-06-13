package chapter2;

public class Reservation {

    private Customer customer;  // 고객
    private Screening screening; // 상영 정보
    private Money fee; // 예매 요금
    private int audienceCount; // 인원수

    public Reservation(Customer customer, Screening screening, Money fee, int audienceCount) {
        this.customer      = customer;
        this.screening     = screening;
        this.fee           = fee;
        this.audienceCount = audienceCount;
    }

}

// 영화를 예매하기 위해 screening Movie Reservation 인스턴스들은 서로의 메서드를 호출하며 상호 작용한다.
// 이것을 객체간의 협력(Collaboration)이라고 부른다.

// 객체는 다른 객체의 인터페이스에 공개된 행동을 수행하도록 요청할 수 있으며
// 요청을 받은 객체는 자율적인 방법에 따라 요청을 처리한 후 응답 합니다.

// 객체가 다른 객체와 상호작용할 수 있는 유일한 방법은 메시지를 전송하는 것입니다.

