import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SLListTest {

    @Test
    void getFirstOnEmptyList() {   // test  on an empty list
        SLList list = new SLList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.getFirst());
    }

    @Test
    void getFirstCorrectly() {   // test if the getFirst is working correctly
        SLList list = new SLList();
        list.addFirst(10);
        list.addFirst(20);
        assertEquals(20, list.getFirst());
    }

    @Test
    void ezGetSingleElementAtIndexZero() {  // check on the sole element in the list
        SLList list = new SLList();
        list.addFirst(10);
        assertEquals(10, list.getFirst());
    }

    @Test
    void testGetAtIndex_workingCorrectly() {  // test getIndex working correctly
        SLList list = new SLList();
        list.addFirst(10); // index 0
        list.addFirst(20); // index 1
        list.addFirst(30); // index 2

        assertEquals(30, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(10, list.get(2));
    }


    @Test
    void testGetIndexOutOfBoundsNegative() {  // getIndex for negative and assertThrows
        SLList list = new SLList();

        // empty list
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));

        // add elements then test for out of bounds
        list.addFirst(10);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }
}