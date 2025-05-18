public class SLList {
    private class IntNode {
        int value; // an int data item
        IntNode next; // ref to the next node

        public IntNode(int val, IntNode r) {
            this.value = val; this.next = r;
        }
    }

    private IntNode first;

    public SLList() {
        first = null;
    }


    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public int getFirst() {
        if (first == null) {
            throw new IndexOutOfBoundsException("List is currently empty");
        }
        return first.value;
    }

    public int get(int index) {
        if (index < 0 ) {
            throw new IndexOutOfBoundsException("Index can not be negative");
        }
        IntNode current = first;

        for (int i = 0; i < index; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            current = current.next;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return current.value;
    }

}
