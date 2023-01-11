package app.product.subproduct;

import app.product.Product;

public class Side extends Product { // Product 상속 받음
    private int hotSauce;
    private int mustard;


    public Side(int id, String name, int price, int kcal, int hotSauce, int mustard) {
        super(id, name, price, kcal);
        this.hotSauce = hotSauce;
        this.mustard = mustard;
    }

    public Side(Side side) {
        super(side.getName(), side.getPrice(), side.getKcal());
        this.hotSauce = side.getHotSauce();
        this.mustard = side.getMustard();
    }

    public void setHotSauce(int hotSauce) {
        this.hotSauce = hotSauce;
    }

    public void setMustard(int mustard) {
        this.mustard = mustard;
    }

    public int getHotSauce() {
        return hotSauce;
    }

    public int getMustard() {
        return mustard;
    }
}
