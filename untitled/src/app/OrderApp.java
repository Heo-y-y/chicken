package app;

import app.product.Product;
import app.product.ProductRepository;

import java.util.Scanner;


public class OrderApp { // 프로그램 실행 로직 담당
    public void start() { // 프로그램 실행 메서드
        Scanner scanner = new Scanner(System.in); // Scanner 사용 인스턴스
//       ProductRepository를 인스턴스화 하고,
//        getAllProducts() 반환 값을 전달하면서,
//        Menu 클래스를 인스턴스화
        ProductRepository productRepository = new ProductRepository();
        Product[] products = productRepository.getAllProducts();
        Menu menu = new Menu(products);
        Cart cart = new Cart(productRepository, menu);
        Order order = new Order(cart);

        System.out.println("🍗 Chicken Order Service");

        while (true) {
            menu.printMenu(); // 메뉴를 출력해주는 메서드
            String input = scanner.nextLine(); // 사용자 입력 받는 변수

            if (input.equals("+")) {
                order.makeOrder();
                break;
            } else {
                try { // 예외 처리 적용
                    int menuNumber = Integer.parseInt(input);

                    if (menuNumber == 0) cart.printCart();
                    else if (1 <= menuNumber && menuNumber <= products.length) cart.addToCart(menuNumber);
                } catch (Exception e) {

                }
            }
        }
    }
}
