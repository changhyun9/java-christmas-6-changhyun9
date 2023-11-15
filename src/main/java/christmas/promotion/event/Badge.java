package christmas.promotion.event;

public enum Badge {
    산타("산타"),
    트리("트리"),
    별("별"),
    없음("없음");

    private String badge;

    Badge(String badge) {
        this.badge = badge;
    }

    public String getBadge() {
        return badge;
    }
}
