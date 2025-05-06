/*
Name: Chaiyanun Sakulsaowapakkul
ID: 6681299
 */

package week2;

public class IntNode {
    int head;
    IntNode next;
    IntNode(int head, IntNode next) {
        this.head = head;
        this.next = next;
    }

    int size() {
        if (this.next == null)
            return 1;
        return 1 + this.next.size();
    }

    public String toString() {
        if (this.next == null)
            return String.valueOf(this.head);  //base case
        // other cases
        return String.valueOf(this.head) + ", "
                + this.next.toString();
    }

    int iterSize() {
        IntNode current = this;
        int size = 0;

        while (current != null) {   // if it's not the end yet (not null)
            size += 1;
            current = current.next; // keep adding it then count the size
        }
        return size;
    }

    public String iterativeToString() {
        IntNode current = this;
        String result = "";

        while (current.next != null) {
            result += String.valueOf(current.head) + ", ";
            current = current.next;
        }
        result += String.valueOf(current.head);
        return result;
    }

    public int get(int i) {
        IntNode current = this;
        int answer = 0;
        for (int index = 0; index <= i; index++) {
            answer = current.head;
            current = current.next;
        }
        return answer;
    }

    public void set(int i, int newValue) {
        IntNode current = this;

        for (int index = 0; index < i; index++) {
            current = current.next;
        }
        current.head = newValue;
    }

    public IntNode incrlist(int delta) {
        if (this.next == null) {
            return new IntNode(this.head + delta, null);  // have head, next point to null
        } else {                                               // have head, next point recursion part
            return new IntNode(this.head + delta, this.next.incrlist(delta));
        }
    }
}
