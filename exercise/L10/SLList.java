package week2;

import java.util.Iterator;

public class SLList<T> implements Iterable<T> {
    private static class Node<T> {
        T head;
        Node<T> next;

        Node(T head, Node<T> next) {
            this.head = head;
            this.next = next;
        }
    }

    private class SLListIterator implements Iterator<T> {
        private Node<T> current = sen.next;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T value = current.head;
            current = current.next;
            return value;
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new SLListIterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // comparing to myself so return true

        // instanceof is checking of o is an instance of SLList or not
        // ! is there to negate so flip "o is not an instance of"
        if (!(o instanceof SLList<?> other)) return false;
        if (this.size != other.size) return false; // check the size

        Node<T> thisCurrent = this.sen.next;    // start at the real first node of each
        Node<?> otherCurrent = other.sen.next;

        while (thisCurrent != null && otherCurrent != null) {  // if both not empty

            // if this current head is not equal to other's current head
            // then return false
            if (!thisCurrent.head.equals(otherCurrent.head)) {
                return false;
            }
            thisCurrent = thisCurrent.next;
            otherCurrent = otherCurrent.next;

        }
        return true;
    }

    public static void main(String[] args) {
        SLList<String> list1 = new SLList<String>();
        SLList<String> list2 = new SLList<String>();

        list1.addFirst("Hello");
        list1.addLast("World");

        list2.addFirst("Hello");
        list2.addLast("World");

        System.out.println(list1.equals(list2));

        list2.addFirst("Virus");
        System.out.println(list2.equals(list1));

        for (String str : list2) {
            System.out.println(str);
        }
    }

    //private Node<T> first;
    /*
    sen is the sentinel node
    sen.next is the real first
     */
    private Node<T> sen = new Node<>(null, null);
    private int size = 0;


    //add x to the front of the list
    public void addFirst(T x) {
//        Node<T> newNode = new Node<T>(x, first);
//        first = newNode;
        sen.next = new Node<>(x, sen.next);
        size += 1;
    }

    //return the ele at the front of the list
    public T getFirst() {
        return sen.next.head;
    }

    public int size() {
        return size;
    }

    public void addLast(T x) {
        Node<T> p = sen;
        while (p.next != null) {
            p = p.next;
        }
        // want: p to be the last in the list
        p.next = new Node<T>(x, null);
        size += 1;
    }

    public void addLastNumTwo(T x) {
        Node<T> current = sen.next;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<T>(x, null);
        size += 1;
    }

    public void insert(int newValue, T k) {
        Node<T> current = sen;
        for (int i = 0; i < newValue; i++) {
            current = current.next;
        }
        current.next = new Node<T>(k, current.next);
        size += 1;
    }

    public T getLast() {
        Node<T> p = sen.next;
        while (p.next != null) {
            p = p.next;
        }
        return p.head;
    }

    public String toString() {
        String answer = "";
        Node<T> current = sen.next;
        if (current == null) {
            return answer;
        }
        while (current.next != null) {
            answer += current.head + ", ";
            current = current.next;
        }
        answer += current.head;
        return answer;
    }

    public void removeFirst() {
        //sen.next = sen.next.next;
        Node<T> p = sen.next;
        if (p == null) {
            //
        } else {
            sen.next = p.next; // mind blown:   sen.next is now p.next
            size -= 1;         //               instead of p = sen.next
        }
    }

    public void removeLast() {
        Node<T> current = sen.next;
        Node<T> prev = sen;
        if (current == null) {   // it's like a train sen is the top base then start the actual node
            return;       // imagine looping through Seele thighs, Top sen -> left thigh -> right thigh
        }
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        prev.next = null;
        size -= 1;
    }

    public double getAverage() {
        if (size == 0) return 0.0;

        if (!(sen.next.head instanceof Number)) {
            throw new UnsupportedOperationException("Average only works for number types.");
        }

        double sum = 0;
        int count = 0;
        Node<T> current = sen.next;
        while (current != null) {
            sum += ((Number) current.head).doubleValue();
            count++;
            current = current.next;
        }
        return sum / count;
    }
}

