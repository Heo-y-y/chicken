package app.product.subproduct;

import app.product.Product;

public class Side extends Product { // Product 상속 받음
    private boolean sauce; // true면 핫 소스, false면 머스타드

    public Side(int id, String name, int price, int kcal, boolean sauce) {
        super(id, name, price, kcal);
        this.sauce = sauce;
    }

    public boolean sauce() {
        return sauce;
    }

    public void setSauce(boolean sauce) {
        this.sauce = sauce;
    }
}
