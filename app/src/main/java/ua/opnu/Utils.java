package ua.opnu;

import java.util.function.Predicate;
import java.util.Arrays;

public class Utils {
    public static <T> T[] filter(T[] input, Predicate<T> p) {
        Object[] temp = new Object[input.length];
        int idx = 0;
        for (T item : input) {
            if (p.test(item)) {
                temp[idx++] = item;
            }
        }
        return Arrays.copyOf(temp, idx, (Class<T[]>) input.getClass());
    }

    public static <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element) {
        for (T item : array) {
            if (item.compareTo(element) == 0) return true;
        }
        return false;
    }
}
