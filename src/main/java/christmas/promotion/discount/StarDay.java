package christmas.discount;

import java.util.Arrays;
import java.util.List;

public enum StarDay {
    STAR_DAY(Arrays.asList(3,10,17,24,25,31));

    private final List<Integer> list;

    StarDay(List<Integer> list) {
        this.list = list;
    }

    public boolean containDay(int day) {
        boolean contains = list.contains(day);
        return contains;
    }
}
