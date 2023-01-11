package app;

import app.discount.discountCondition.HowToReceiveCondition;

public class Order {
    private Cart cart;

    public Order(Cart cart) {
        this.cart = cart;
    }

    public void makeOrder() {
        // 인스턴스 생성
        HowToReceiveCondition howToReceiveCondition = new HowToReceiveCondition();
        // 할인 적용을 해주는 메서드 호출
        howToReceiveCondition.checkDiscountCondition();

        int totalPrice= cart.calculateTotalPrice();

        int finalPrice = totalPrice;

        if (howToReceiveCondition.isSatisfied()){
            finalPrice = howToReceiveCondition.deliveryFree(finalPrice);
        } else {
            finalPrice = howToReceiveCondition.applyDiscount(finalPrice);
        }

        System.out.println("[📣] 주문이 완료되었습니다. ");
        System.out.println("[📣] 주문 내역은 다음과 같습니다. ");
        System.out.println("-".repeat(60));

        cart.printCartItemDetails();

        System.out.println("-".repeat(60));
        System.out.printf("금액 합계      : %d원\n", totalPrice);
        System.out.printf("수령 적용 금액 : %d원\n", finalPrice);
    }
}
