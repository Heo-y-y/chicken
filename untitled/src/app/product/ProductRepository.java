package app.product;

import app.product.subproduct.Chicken;
import app.product.subproduct.Drink;
import app.product.subproduct.Side;

public class ProductRepository { // 상품 저장소

    private final Product[] products = { // 다형성 활용 : 상품 저장소에 상품 배열 인스턴스 배을 필드로 만듬(업캐스팅)
            new Chicken(1, "후라이드", 12000, 400),
            new Chicken(2, "자메이카", 16000, 500),
            new Side(3, "치즈스틱", 1000, 200,  0,0),
            new Side(4, "감자튀김", 1000, 200, 0, 0),
            new Drink(5, "펩시제로", 1000, 0, true),
            new Drink(6, "얼음맥주", 1000, 150, true)
    };

    public Product[] getAllProducts() { // 외부에서 접근할 수 있도록 get메서드 생성
        return products;
    }

    public Product findById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) return product;
        }
        return null;
    }
}
