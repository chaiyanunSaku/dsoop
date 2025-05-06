package week2;

public class SLList {
    private static class IntNode {
        int head;
        IntNode next;

        IntNode(int head, IntNode next) {
            this.head = head;
            this.next = next;
        }
    }

    //private IntNode first;
    /*
    sen is the sentinel node
    sen.next is the real first
     */
    private IntNode sen = new IntNode(314, null);
    private int size = 0;

    //add x to the front of the list
    public void addFirst(int x) {
//        IntNode newNode = new IntNode(x, first);
//        first = newNode;
        sen.next = new IntNode(x, sen.next);
        size += 1;
    }

    //return the ele at the front of the list
    public int getFirst() {
        return sen.next.head;
    }

    public int size() {
        return size;
    }

    public void addLast(int x) {
        IntNode p = sen;
        while (p.next != null) {
            p = p.next;
        }
        // want: p to be the last in the list
        p.next = new IntNode(x, null);
        size += 1;
    }

    public int getLast() {
        IntNode p = sen.next;
        while (p.next != null) {
            p = p.next;
        }
        return p.head;
    }

    public String toString() {
        String answer = "";
        IntNode p = sen.next;
        if (p == null) {
            return answer;
        }
        while (p.next != null) {
            answer += p.head + ", ";
            p = p.next;
        }
        answer += p.head;
        return answer;
    }

    public void removeFirst() {
        //sen.next = sen.next.next;
        IntNode p = sen.next;
        if (p == null) {
            //
        } else {
            sen.next = p.next; // mind blown:   sen.next is now p.next
            size -= 1;         //               instead of p = sen.next
        }
    }

    public void insert(int newValue, int k) {
        IntNode p = sen.next;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }
        //o
    }
}
