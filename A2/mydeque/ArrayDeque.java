package A2.mydeque;

import java.util.Arrays;

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    private static final int INITIAL_CAPACITY = 8;

    @SuppressWarnings("unchecked")
    public ArrayDeque() {
        items = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
        nextFirst = 7;
        nextLast = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int plusOne(int index) {
        return (index + 1) % items.length;
    }

    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    public void addFirst(T item) {
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
        resizeIfNeeded();
    }

    public void addLast(T item) {
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;
        resizeIfNeeded();
    }

    public T removeFirst() {
        if (isEmpty()) return null;
        nextFirst = plusOne(nextFirst);
        T item = items[nextFirst];
        items[nextFirst] = null;
        size--;
        resizeIfNeeded();
        return item;
    }

    public T removeLast() {
        if (isEmpty()) return null;
        nextLast = minusOne(nextLast);
        T item = items[nextLast];
        items[nextLast] = null;
        size--;
        resizeIfNeeded();
        return item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) return null;
        int actualIndex = (plusOne(nextFirst) + index) % items.length;
        return items[actualIndex];
    }

    @SuppressWarnings("unchecked")
    private void resizeIfNeeded() {
        if (size == items.length) {
            resize(items.length * 2);
        } else if (items.length >= 16 && size < items.length / 4) {
            resize(items.length / 2);
        }
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        int current = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            newItems[i] = items[current];
            current = plusOne(current);
        }
        items = newItems;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    public ArrayDeque(ArrayDeque<T> other) {
        this();
        for (int i = 0; i < other.size(); i++) {
            this.addLast(other.get(i));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int index = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            sb.append(items[index]);
            if (i < size - 1) {
                sb.append(", ");
            }
            index = plusOne(index);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addFirst(0);
        System.out.println("Deque: " + deque);
        System.out.println("Size: " + deque.size());
        System.out.println("Removed first: " + deque.removeFirst());
        System.out.println("Removed last: " + deque.removeLast());
        System.out.println("Deque: " + deque);
        System.out.println("Copied deque:");
        ArrayDeque<Integer> copy = new ArrayDeque<>(deque);
        System.out.println(copy);
    }
}
