package christmas.discount;

public class OrderDiscount {
    private final DiscountList discount;
    private final int discountPrice;

    public OrderDiscount(DiscountList discount, int discountPrice) {
        this.discount = discount;
        this.discountPrice = discountPrice;
    }

    public String getDiscountName() {
        return discount.getDiscountName();
    }

    public int getDiscountPrice() {
        return discountPrice;
    }
}
