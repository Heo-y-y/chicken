package app.product.subproduct;

import app.product.Product;

public class Chicken extends Product { // Product을 상속 받음

    public Chicken(int id, String name, int price, int kcal) {
        super(id, name, price, kcal);
    }

    public Chicken(Chicken chicken) {
        super(chicken.getName(), chicken.getPrice(), chicken.getKcal());
    }
}
