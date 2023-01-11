package app.discount.discountPolicy;

public class FixedAmountAdditionalPolicy{

    private int additionalAmount; // 배달 금액

    public FixedAmountAdditionalPolicy(int additionalAmount) {
        this.additionalAmount = additionalAmount;
    }
    // 배달료 적용 금액을 계산하는 메서드
    public int deliveryCalculationPrice(int price) {
        return price + additionalAmount;
    }
}
