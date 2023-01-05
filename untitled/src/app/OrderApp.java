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
        Menu meue = new Menu(products);

        System.out.println("🍗 Chicken Order Service");

//        while (true) {
            meue.printMenu(); // 메뉴를 출력해주는 메서드
            String input = scanner.nextLine(); // 사용자 입력 받는 변수
//
//            if (시용자의 입력이 +인 경우) {
//                주문 내역 출력
//                break;
//            }
//            else if (사용자 입력이 0인 경우) {
//                장바구니 출력
//            }
//            else if (사용자 입력이 1부터 메뉴 마지막 번호에 해당하는 경우) {
//                사용자가 고른 상품의 옵션을 보여주고 고르게 한 후, 장바구니에 담기
//            }
//        }
    }
}
