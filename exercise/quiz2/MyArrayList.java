package Quiz2;

import java.util.NoSuchElementException;

public class MyArrayList {   // this is a class called "MyArrayList"
    private int[] items;
    private String encryptCode;
    private int size;

    /*
    these three are call instance variables ^^^
    they are private so only the class itself can access them
     */

    public MyArrayList() {  // this is called constructor
        items = new int[2];
        size = 0;
        encryptCode = null;
        /*
        This creates an array with space for 2 integers, items[0] and items[1].
        even the array has room for 2, but we haven't added anything yet so size is zero.
        no encryption code yet, we will set it later.
         */
    }

    public void grow(int newCapacity) {   // this is a method called "grow"
        int[] newItems = new int[newCapacity];
        /*
        Create a new array that is bigger
        if newCapacity = 4, now we have: newItems[0], newItems[1], newItems[2], newItems[3].
         */

        System.arraycopy(items, 0, newItems, 0, size);
        /*
        items = current data
        0 -> start copy from index 0
        newItems = copy into this array
        0 -> starting from index 0
        size -> only copy the used portion

        Think of it like: "copy the real data from the old array into a new bigger array."
         */
        items = newItems;

        /*
        why do we need to grow?
        because Arrays in Java cannot change size once created, but we can
        1. Create a bigger array
        2. Copying over the old elements
        3. Replacing the reference
         */
    }

    public void add(int value) {
        if (size == items.length) {   // checking if the array is full
            grow(items.length * 2);  // if full, double the size
        }
        // items[size++] = value;  -->  unreadable
        items[size] = value;  // inserting the "value" integer into the next available slot
        size += 1;
    }

    public void setEncryptCode(String val) {
        this.encryptCode = val;
        // giving some List an EncryptCode which is String val
    }

    public int removeFirst() {
        if (size == 0) {                    // check if size is zero
            throw new NoSuchElementException("Our array is empty...");
        }
        int removed = items[0];  // we will return this later, it's the value at index 0
        // System.arraycopy(items, 1, items, 0, size - 1);  // one line copy array
        for (int i = 1; i < size; i++) {   // start at i = 1, it moves everything one spot to the left
            items[i-1] = items[i];
        }
        size -= 1;
        return removed;
    }

    public boolean equals(Object o) {
        if (o == this) return true; // same object
        if (o == null || this.getClass() != o.getClass()) return false; // null or different class

        MyArrayList other = (MyArrayList) o;
        /*
        “Take the input object o and treat it as a MyArrayList (if possible),
         and store it in a variable called other.”
         */

        if (this.encryptCode == null) {
            if (other.encryptCode != null) return false;  // if one is null and other is not then false
        } else {
            if (!this.encryptCode.equals(other.encryptCode)) return false;
        }   // if both encryptCode is null then use .equals() to compare their encryptCode

        if (this.size != other.size) return false;

        for (int i = 0; i < this.size; i++) {
            if (this.items[i] != other.items[i]) return false;
        }
        return true;
    }

}
