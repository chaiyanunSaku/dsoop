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

    public void addLastNumTwo(int x) {
        IntNode current = sen.next;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new IntNode(x, null);
        size += 1;
    }

    public void insert(int newValue, int k) {
        IntNode current = sen;
        for (int i = 0; i < newValue; i++) {
            current = current.next;
        }
        current.next = new IntNode(k, current.next);
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
        IntNode current = sen.next;
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
        IntNode p = sen.next;
        if (p == null) {
            //
        } else {
            sen.next = p.next; // mind blown:   sen.next is now p.next
            size -= 1;         //               instead of p = sen.next
        }
    }

    public void removeLast() {
        IntNode current = sen.next;
        IntNode prev = sen;
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
        if (size == 0) {
            return 0.0;
        }
        double sum = 0;
        double count = 0;
        IntNode current = sen.next;
        while (current.next != null) {
            sum += current.head;
            count++;
            current = current.next;
        }
        sum += current.head;
        count++;
        return sum / count;
    }
}

