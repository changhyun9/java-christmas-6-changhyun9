package christmas.promotion.event;

import christmas.order.menu.Menu;

public class Event {
    private final EventMenu eventMenu;
    private final Badge badge;

    public Event(int orderPrice, int discountPrice) {
        this.eventMenu = setEventMenu(orderPrice);
        int promotionPrice = discountPrice + eventMenu.getEventMenuPrice();
        this.badge = setBadge(promotionPrice);
    }

    private EventMenu setEventMenu(int orderPrice) {
        if(orderPrice > 120_000){
            EventMenu presentation = new EventMenu(Menu.샴페인, 1);
            return presentation;
        }
        EventMenu presentation = new EventMenu(Menu.없음, 0);
        return presentation;
    }

    private Badge setBadge(int promotionPrice) {
        if(promotionPrice > 20_000){
            return Badge.산타;
        }
        if(promotionPrice > 10_000){
            return Badge.트리;
        }
        if (promotionPrice > 5_000) {
            return Badge.별;
        }
        return badge.없음;
    }

    public EventMenu getEventMenu() {
        return eventMenu;
    }

    public String getBadge() {
        return badge.getBadge();
    }
}
