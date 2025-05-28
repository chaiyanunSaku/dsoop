package week6;

public class CountIf<T> {
    private Predicate<T> pred;

    public CountIf(Predicate<T> pred) {
        this.pred = pred;
    }

    public int count(T[] items) {
        int total = 0;
        for (T item : items) {
            if (pred.test(item)) {
                total++;
            }
        }
        return total;
    }
}
