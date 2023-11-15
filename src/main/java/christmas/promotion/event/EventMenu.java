package christmas.promotion.event;

import christmas.order.menu.Menu;

public class EventMenu {
    private final Menu eventMenu;
    private final int quantity;

    public EventMenu(Menu eventMenu, int quantity) {
        this.eventMenu = eventMenu;
        this.quantity = quantity;
    }

    public String getEventMenuName() {
        return eventMenu.getName();
    }

    public int getEventMenuPrice() {
        return eventMenu.getPrice();
    }

    public int getQuantity() {
        return quantity;
    }
}
