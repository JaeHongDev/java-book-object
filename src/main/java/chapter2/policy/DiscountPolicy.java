package chapter2.policy;

import chapter2.Money;
import chapter2.Screening;

import java.util.ArrayList;
import java.util.List;
// 할인 정책은 금액 할인 정책과 비율 할인 정책으로 구분된다.
// 두 가지 할인 정책을 각각 AmountDiscountPolicy와 PercentDiscountPolicy라는 클래스로 구현함.
// 두 클래스는 대부분의 코드가 유사하고 할인 요금을 계산하는 방식만 조금 다르다.
// 따라서 두 클래스 사이의 중복 코드를 제거하기 위해 공통코드를 보관할 장소가 필요하다.

public abstract class DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = conditions;
    }

    public Money caclulateDiscountAmount(Screening screening){
        for (DiscountCondition each : conditions) {
            if(each.isSatisfiedBy(screening)){
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    abstract  protected Money getDiscountAmount(Screening screening);
}

// DiscountPolicy는 DiscountCondition의 리스트인 conditions를 인스턴스 변수로 가지기 때문에
// 하나의 할인 정책은 여러 개의 할인 조건을 포함할 수 있다.
// calculateDiscountAmount 메서드는 전체 할인 조건에 대해 차례대로 DiscountCondition의 isSatisfiedBy 메서드르 호출한다.
// isSatisfiedBy 메서드는 인자로 전달된 Screening이 할인 조건을 만족시킬 경우에는 true를 만족시키지 못할 경우에는 false를 반환한다.
// 할인 조건을 만족하는 DiscountCondition이 하나라도 존재하는 경우에는 추상 메서드인 getDiscountAmount 메서드를 호출해 할인 요금을 계산한다.
// 만족하는 할인 조건이 하나라도 존재하지 않는다면 할인 요금으로 0원을 반환한다.

// DiscountPolicy는 할인 여부와 요금 계산에 필요한 전체적인 흐름은 정의하지만 실제로 요금을 계산하는 부분은 추상 메서드인 getDiscountAmount
// 메서드에게 위임한다. 실제로는 DiscountPolicy를 상속받은 자식 클래스에서 오버라이딩한 메서드가 실행된다.
// 이처럼 부모 클래스에 기본적인 알고리즘의 흐름을 구현하고 중간에 필요한 처리를 자식 클래스에게 위임하는 디자인 패턴을 TEMPLATE METHOD패턴이라고 부른다.
