package peak;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class PusheenJoiner<T> implements Iterable<T> {
    private final Iterable<T> left;
    private final Iterable<T> right;
    private final Predicate<T> filter;

    public PusheenJoiner(Iterable<T> left, Iterable<T> right) {
        this.left = left;
        this.right = right;
        this.filter = null;
    }
    public PusheenJoiner(Iterable<T> left, Iterable<T> right, Predicate<T> filter) {
        this.left = left;
        this.right = right;
        this.filter = filter;
    }

    @Override
    public Iterator<T> iterator() {
        return new PusheenJoinerIterator();
    }

    private class PusheenJoinerIterator implements Iterator<T> {
        private Iterator<T> leftIterator;   // goes through the left side
        private Iterator<T> rightIterator;  // goes through the right side
        private Iterator<T> currentIterator; // points to either left or right

        private boolean usingRight = false; // tells us if we already switched to right
        private T nextElement;              // stores the next valid item
        private boolean hasNextReady = false; // have we already found the next item?

        public PusheenJoinerIterator() {
            this.leftIterator = left.iterator();   // get iterator for left
            this.rightIterator = right.iterator(); // get iterator for right
            this.currentIterator = leftIterator;   // start with left
        }

        @Override
        public boolean hasNext() {
            // If we already found the next item, just say yes
            if (hasNextReady) {
                return true;
            }

            // Try to find the next valid item (passes the filter if there's one)
            while (true) {
                if (currentIterator.hasNext()) {
                    T candidate = currentIterator.next();

                    // If there's no filter, or the candidate passes the filter:
                    if (filter == null || filter.test(candidate)) {
                        nextElement = candidate;   // store it
                        hasNextReady = true;       // mark it as ready
                        return true;
                    }
                    // Otherwise, keep looping to find a good one
                } else {
                    // If we just finished left, switch to right
                    if (!usingRight) {
                        currentIterator = rightIterator;
                        usingRight = true;
                    } else {
                        // Already finished both left and right
                        return false;
                    }
                }
            }
        }

        @Override
        public T next() {
            // Make sure there's a next item
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }

            hasNextReady = false;   // mark that we're consuming it now
            return nextElement;     // return the stored value
        }
    }
    public static void main(String[] args) {
        List<Integer> a = List.of(1,2,3);
        List<Integer> b = List.of(4,5,6,42);
        PusheenJoiner<Integer> joined = new PusheenJoiner<Integer>(a, b);
        for (Integer ele : joined) {
            System.out.println(ele);
        }
    }
}
