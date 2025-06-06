

public class LinkedListDeque<T> implements Deque<T> {

    private class Node {
        T item;
        Node prev;
        Node next;


        Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;

        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {   // newNode's prev is sentinel, next is current first
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node newNode = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder answer = new StringBuilder();
        Node current = sentinel.next;
        while (current != sentinel) {
            answer.append(current.item);
            if (current.next != sentinel) {
                answer.append(", ");
            }
            current = current.next;
        }
        return answer.toString();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node first = sentinel.next;  // save the first node
        T item = first.item;         // get its item to return
        sentinel.next = first.next;  // bypass the first node
        first.next.prev = sentinel;  // link back to sentinel
        size--;
        return item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node last = sentinel.prev;
        T item = last.item;
        sentinel.prev = last.prev; // point sentinel to last.prev
        last.prev.next = sentinel; // last.prev points to sentinel
        size--;
        return item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null; // out of bound checked
        }

        Node current = sentinel.next; // start from the first real node
        for (int i = 0; i < index; i++) { // loop 'index' time
            current = current.next;       // move to the next node
        }
        return current.item;  // return at given index
    }

    public LinkedListDeque(LinkedListDeque<T> other) {
        this(); // call the default constructor
        for (int i = 0; i < other.size; i++) {
            this.addLast(other.get(i));  // new deque is "this"
        }   // other.get(i), "other" is the original deque then add it to the new deque "this"
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>();
        deque.addFirst(10);
        deque.addLast(20);
        deque.addFirst(5);
        deque.addLast(25);
        System.out.println("Deque contents: " + deque.toString());
        System.out.println("Removed: " + deque.removeFirst());
        System.out.println("Deque contents: " + deque.toString());
        System.out.println("Removed: " + deque.removeLast());
        System.out.println("Deque contents: " + deque.toString());
        deque.addLast(40);
        System.out.println("Deque contents: " + deque.toString());
        System.out.println("Deque gets: " + deque.get(1));

        LinkedListDeque<Integer> copy = new LinkedListDeque<>(deque);
        System.out.println("Copied deque:   " + copy.toString());
        System.out.println("Removed deque: " + deque.removeFirst());
        System.out.println("Deque contents: " + deque.toString());
        System.out.println("Copied deque:   " + copy.toString());
    }
}
