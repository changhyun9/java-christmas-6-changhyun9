package christmas.menu;

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
            throw new IllegalArgumentException("[ERROR] Enter correct format (ex: 해산물파스타-2)");
        }
    }

    private void validateExist(String name) {
        boolean menu = Menu.findMenu(name);
        if(!menu){
            throw new IllegalArgumentException("[ERROR] Enter exist menu");
        }
    }

    private void validateQuantity(String quantity){
        int menuQuantity = Integer.parseInt(quantity);
        if(menuQuantity < MIN_QUANTITY || menuQuantity > MAX_QUANTITY){
            throw new IllegalArgumentException("[ERROR] Enter Range 1 ~ 20");
        }
    }

    public Menu getMenuName() {
        return menuName;
    }

    public int getQuantity() {
        return quantity;
    }
}
