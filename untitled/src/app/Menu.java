package app;

import app.product.Product;
import app.product.subproduct.Chicken;
import app.product.subproduct.Drink;
import app.product.subproduct.Side;

public class Menu { // Menu 객체는 메뉴를 출력해주는 기능 수행
    private Product[] products;

    public Menu(Product[] products) {
        this.products = products;
    }
    // Menu 클래스의 products 필드를 반복문으로 순회하면서, 각각의 카테고리에 맞는 상품 출력
    public void printMenu() { // 메뉴판을 출력해주는 메서드
        System.out.println("[🔻] 메뉴");
        System.out.println("-".repeat(60));

        printChickens(); // 리팩토링: 동일한 동작을 하는 코드를 개선하는 작업
        printSides(); // 리팩토링: 동일한 동작을 하는 코드를 개선하는 작업
        printDrinks(); // 리팩토링: 동일한 동작을 하는 코드를 개선하는 작업

        System.out.println();
        System.out.println("🧺 (0) 장바구니");
        System.out.println("📦 (+) 주문하기");
        System.out.println("-".repeat(60));
        System.out.print("[📣] 메뉴를 선택해주세요 : ");
    }

    private void printDrinks() {
        System.out.println("🥤 음료");
        for (Product product : products) { // products를 product에 넣어주고,
            if (product instanceof Drink) { // 만약 좌항이 우항 클래스와 같거나 하위 클래스면, 출력
                printEachMenu(product); // 리팩토링: 동일한 동작을 하는 코드를 개선하는 작업
            }
        }
        System.out.println();
    }

    private void printSides() {
        System.out.println("🍟 사이드");
        for (Product product : products) { // products를 product에 넣어주고,
            if (product instanceof Side) { // 만약 좌항이 우항 클래스와 같거나 하위 클래스면, 출력
                printEachMenu(product); // 리팩토링: 동일한 동작을 하는 코드를 개선하는 작업
            }
        }
        System.out.println();
    }

    private void printChickens() {
        System.out.println("🍗 치킨");
        for (Product product : products) { // products를 product에 넣어주고,
            if (product instanceof Chicken) { // 만약 좌항이 우항 클래스와 같거나 하위 클래스면, 출력
                printEachMenu(product); // 리팩토링: 동일한 동작을 하는 코드를 개선하는 작업
            }
        }
        System.out.println();
    }

    private static void printEachMenu(Product product) {
        System.out.printf(
                "   (%d) %s %5dKcal %5d원\n",
                product.getId(), product.getName(), product.getKcal(), product.getPrice()
        );
    }
}
