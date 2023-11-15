package christmas.order.menu;

public class OrderMenu {
    public static final int MIN_QUANTITY = 1;
    public static final int MAX_QUANTITY = 20;
    private final Menu menuName;
    private final int quantity;

    public OrderMenu(String input) {
        validateInputFormat(input);
        String[] split = input.split("-");
        validateExist(split[0]);
        validateQuantity(split[1]);
        this.menuName = Menu.valueOf(split[0]);
        this.quantity = Integer.parseInt(split[1]);
    }

    private void validateInputFormat(String input) {
        boolean matches = input.matches("^[ㄱ-ㅎ가-힣]*-[0-9]*$");
        if (!matches) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void validateExist(String name) {
        boolean menu = Menu.findMenu(name);
        if(!menu){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void validateQuantity(String quantity){
        int menuQuantity = Integer.parseInt(quantity);
        if(menuQuantity < MIN_QUANTITY || menuQuantity > MAX_QUANTITY){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public String getMenuName() {
        return menuName.getName();
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice(){
        int price = menuName.getPrice();
        return price * quantity;
    }

    public String getCategory() {
        return menuName.getCategory();
    }
}
