package app.product.subproduct;

import app.product.Product;

public class Chicken extends Product { // Product을 상속 받음
    private boolean delivery; // 배달 여부 true면 +3000, fase면 0 (식당)
    private boolean packaging; // 포장 여부 true면 -3000, fase면 0 (식당)

    public Chicken(int id, String name, int price, int kcal, boolean delivery, boolean packaging) {
        super(id, name, price, kcal);
        this.delivery = delivery;
        this.packaging = packaging;
    }

    public boolean delivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public boolean packaging() {
        return packaging;
    }

    public void setPackaging(boolean packaging) {
        this.packaging = packaging;
    }
}
