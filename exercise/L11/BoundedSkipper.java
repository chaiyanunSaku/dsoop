package week6;

import java.util.Iterator;

import java.util.Iterator;

public class BoundedSkipper implements Iterable<Integer> {
    private int k;
    private int n;

    public BoundedSkipper(int k, int n) {
        this.k = k;
        this.n = n;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new BoundedSkipperIterator();
    }

    private class BoundedSkipperIterator implements Iterator<Integer> {
        private int count = 0;    // How many valid values we've returned
        private int current = 1;  // The current number we're checking

        @Override
        public boolean hasNext() {
            return count < n;
        }

        @Override
        public Integer next() {
            while (true) {
                // Check if current number is valid
                if (isValid(current)) {
                    int result = current;
                    count++;
                    current++;
                    return result;
                }
                current++;
            }
        }

        private boolean isValid(int num) {
            return num % k != 0 && !String.valueOf(num).contains(String.valueOf(k));
        }
    }
}

