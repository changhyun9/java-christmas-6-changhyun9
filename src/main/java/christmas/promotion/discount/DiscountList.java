package christmas.promotion.discount;

public enum DiscountList {
    크리스마스디데이("크리스마스 디데이 할인"),
    평일할인("평일 할인"),
    주말할인("주말 할인"),
    특별할인("특별 할인");

    private String discountName;

    DiscountList(String discountName) {
        this.discountName = discountName;
    }

    public String getDiscountName() {
        return discountName;
    }
}
