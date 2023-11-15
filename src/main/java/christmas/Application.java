package christmas;

import christmas.service.Service;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Service service = new Service();
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        while (true) {
            try {
                service.order();
                service.printEventPlanner();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            break;
        }
    }
}
