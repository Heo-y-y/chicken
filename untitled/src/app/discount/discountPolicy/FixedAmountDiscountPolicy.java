package app.discount.discountPolicy;

public class FixedAmountDiscountPolicy {

    // 할인, 추가 비율
    private int discountAmount; // 할인 금액

    // 생성자
    public FixedAmountDiscountPolicy(int discountAmount) {
        this.discountAmount = discountAmount;
    }
    // 포장 할인 금액을 계산하는 메서드
    public int calculateDiscountedPrice(int price) {
        return price - discountAmount;
    }

}
