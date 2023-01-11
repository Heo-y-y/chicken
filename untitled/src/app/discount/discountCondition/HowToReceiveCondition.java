package app.discount.discountCondition;

import app.discount.discountPolicy.FixedAmountAdditionalPolicy;
import app.discount.discountPolicy.FixedAmountDiscountPolicy;

import java.util.Scanner;

public class HowToReceiveCondition {

    private FixedAmountDiscountPolicy fixedAmountDiscountPolicy = new FixedAmountDiscountPolicy(3000);
    private FixedAmountAdditionalPolicy fixedAmountAdditionalPolicy = new FixedAmountAdditionalPolicy(3000);

    private boolean isSatisfied;

    public boolean isSatisfied() {
        return isSatisfied;
    }

    private void setSatisfied(boolean satisfied) {
        isSatisfied = satisfied;
    }

    public void checkDiscountCondition() { // 할인 적용을 해주는 메서드
        Scanner scanner = new Scanner(System.in);

        System.out.println("수령 방법을 선택하세요. (1)_배달 (2)_포장");
        String input = scanner.nextLine();

        if (input.equals("1")) setSatisfied(true);

        else if(input.equals("2")) setSatisfied(false);
    }

    public int deliveryFree(int price) {
        return fixedAmountAdditionalPolicy.deliveryCalculationPrice(price);
    }

    public int applyDiscount(int price) {
        return fixedAmountDiscountPolicy.calculateDiscountedPrice(price);
    }
}
