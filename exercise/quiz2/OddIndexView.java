package Quiz2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OddIndexView<T> implements Iterable<T> {
    private T[] array;

    private class OddIndexViewIter implements Iterator<T> {
        int curIndex;
        public OddIndexViewIter() { curIndex = 1; }
        public boolean hasNext() {
            return curIndex < array.length;
        }
        public T next() {
            // if there is an item to return, return it
            // otherwise raise an exception NoSuchElementException
            if (hasNext()) {
                T retVal = array[curIndex];
                curIndex += 2;
                return retVal;
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    public OddIndexView(T[] array) { this.array = array; }
    public Iterator<T> iterator() {
        return new OddIndexViewIter();
    }
}
