package app;

import app.product.Product;
import app.product.ProductRepository;
import app.product.subproduct.Chicken;
import app.product.subproduct.Drink;
import app.product.subproduct.Side;

import java.util.Scanner;

public class Cart { // 장바구니 역할을 하는 객체
    private ProductRepository productRepository; // Cart클래스의 필드로 productRepository를 정의

    public Cart(ProductRepository productRepository, Menu menu) { //생성자를 통해 초기화
        this.productRepository = productRepository;
    }

    private Product[] items = new Product[0]; // 장바구니 상품을 의미하는 items를 필드 선언
    private Scanner scanner = new Scanner(System.in);

    public void printCart() { //장바구니 상품을 출력해주는 메서드
        System.out.println("🧺 장바구니");
        System.out.println("-".repeat(60));

        printCartItemDetails();

        System.out.println("-".repeat(60));
        System.out.printf("합계 : %d원\n", calculateTotalPrice());

        System.out.println("이전으로 돌아가려면 엔터를 누르세요. ");
        scanner.nextLine();

    }

    protected void printCartItemDetails() { // 장바구니 상세 출력 메서드

        for (Product product : items) {
            if (product instanceof Chicken) {
                System.out.printf("  %-8s %6d원 (한마리)\n",
                        product.getName(),
                        product.getPrice()
                );
            }
            if (product instanceof Side) {
                if (((Side) product).getHotSauce() != 0){
                    System.out.printf(
                            "  %-8s %6d원 (핫소스 %d개)\n",
                            product.getName(),
                            product.getPrice(),
                            ((Side) product).getHotSauce()
                    );
                } else if (((Side) product).getMustard() != 0) {
                    System.out.printf(
                            "  %-8s %6d원 (머스타드 %d개)\n",
                            product.getName(),
                            product.getPrice(),
                            ((Side) product).getMustard()
                    );
                }
            }

            if (product instanceof Drink) {
                System.out.printf(
                        "  %-8s %6d원 (빨대 %s)\n",
                        product.getName(),
                        product.getPrice(),
                        ((Drink) product).hasStraw() ? "있음" : "없음"
                );
            }
        }
    }

    protected int calculateTotalPrice() {
        int totalPrice = 0;
        for (Product product : items) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public void addToCart(int productId) {
        // Cart에서는 그저 productRepository의 findById()를 호출해주기만 하면 됨 (의존성 주입)
        Product product = productRepository.findById(productId);
        chooseOption(product);
        Product newProduct;
        if (product instanceof Chicken) newProduct = new Chicken((Chicken) product);
        else if (product instanceof Side) newProduct = new Side((Side) product);
        else if (product instanceof Drink) newProduct = new Drink((Drink) product);
        else newProduct = product;

        Product[] newItems = new Product[items.length + 1];
        System.arraycopy(items, 0, newItems, 0, items.length);
        newItems[newItems.length - 1] = newProduct;
        items = newItems;

        System.out.printf("[📣] %s를(을) 장바구니에 담았습니다.\n", product.getName());
    }

    private void chooseOption(Product product) { // 추가 옵션 메서드

        String input;

        if (product instanceof Side) {
            System.out.println("어떤 소스가 필요하신가요? (1)_ 핫소스 (2)_ 머스타드");
            input = scanner.nextLine();
            if (input.equals("1")) {
                System.out.println("핫소스는 몇개가 필요하신가요?");
                input = scanner.nextLine();
                ((Side) product).setMustard(Integer.parseInt(input));
            } else if (input.equals("2")) {
                System.out.println("머스타드는 몇개가 필요하신가요?");
                input = scanner.nextLine();
                ((Side) product).setMustard(Integer.parseInt(input));
            }
        }
        if (product instanceof Drink) {
            System.out.println("빨대가 필요하신가요? (1)_예 (2)_아니오");
            input = scanner.nextLine();
            if (input.equals("2")) ((Drink) product).setHasStraw(false);
            }
        }
    }





