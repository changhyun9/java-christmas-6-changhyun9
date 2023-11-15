package christmas.order.menu;

import java.util.ArrayList;
import java.util.List;

public class OrderMenus {
    public static final int MAX_QUANTITY = 20;
    private final List<OrderMenu> orderMenus;

    public OrderMenus(String orderInput) {
        this.orderMenus = new ArrayList<>();
        String[] split = orderInput.split(",");
        splitOrderMenu(split);
        validateTotalQuantity();
        validateOnlyDrink();

    }

    private void splitOrderMenu(String[] split) {
        for (String input : split) {
            insertMenu(input);
        }
    }

    private void insertMenu(String input) {
        OrderMenu orderMenu = new OrderMenu(input);
        validateDuplicateOrder(orderMenu);
        orderMenus.add(orderMenu);
    }

    private int getOrderQuantity() {
        int orderQuantity = 0;
        for (OrderMenu orderMenu : orderMenus) {
            orderQuantity += orderMenu.getQuantity();
        }
        return orderQuantity;
    }

    private void validateTotalQuantity() {
        int orderQuantity = getOrderQuantity();
        if (orderQuantity > MAX_QUANTITY) {
            throw new IllegalArgumentException("[ERROR] Order Max Quantity is 20");
        }
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (OrderMenu orderMenu : orderMenus) {
            totalPrice += orderMenu.getPrice();
        }
        return totalPrice;
    }

    private void validateDuplicateOrder(OrderMenu orderMenu) {
        String orderMenuName = orderMenu.getMenuName();
        for (OrderMenu menu : orderMenus) {
            String menuName = menu.getMenuName();
            if (menuName.equals(orderMenuName)) {
                throw new IllegalArgumentException("[ERROR] have already same menu");
            }
        }
    }

    private void validateOnlyDrink() {
        int drinkCount = categoryCount("음료");
        if (drinkCount == getSize()) {
            throw new IllegalArgumentException("[ERROR] Can't order only drinks");
        }
    }

    public int getSize() {
        return orderMenus.size();
    }

    public int getDessertQuantity() {
        return categoryCount("디저트");
    }

    public int getMainQuantity() {
        return categoryCount("메인");
    }

    private int categoryCount(String category) {
        int count =0;
        for (OrderMenu orderMenu : orderMenus) {
            String menuCategory = orderMenu.getCategory();
            if (category.equals(menuCategory)) {
                count += orderMenu.getQuantity();
            }
        }
        return count;
    }

    public List<OrderMenu> getOrderMenus() {
        return orderMenus;
    }

}
