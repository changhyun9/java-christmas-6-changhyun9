package christmas.service;

import christmas.order.Order;
import christmas.order.date.OrderDate;
import christmas.order.menu.OrderMenus;
import christmas.ui.InputView;
import christmas.ui.OutputView;

public class Service {

    private Order order;

    public void order() {
        InputView inputView = new InputView();
        String inputOrderDate = inputView.inputOrderDate();
        OrderDate orderDate = new OrderDate(inputOrderDate);
        String inputOrderMenus = inputView.inputOrderMenus();
        OrderMenus orderMenus = new OrderMenus(inputOrderMenus);
        order = new Order(orderDate, orderMenus);
    }

    public void printEventPlanner() {
        OrderDate orderDate = order.getOrderDate();
        System.out.println("12월 " + orderDate.getDate() + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
        OutputView outputView = new OutputView(order);
        outputView.printEvent();
    }
}
