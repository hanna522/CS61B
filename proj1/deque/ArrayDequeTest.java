package deque;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ArrayDequeTest {
    @Test
    public void addTest() {
        ArrayDeque<String> ad1 = new ArrayDeque<String>();

        ad1.addFirst("a");
        assertEquals(1, ad1.size());
        ad1.addLast("b");
        assertEquals(2, ad1.size());

        ad1.printDeque();
        System.out.println();
        System.out.println(ad1.get(0));
        System.out.println(ad1.get(1));
    }

    @Test
    public void removeTest() {
        ArrayDeque<String> ad1 = new ArrayDeque<String>();

        ad1.addFirst("a");
        ad1.addFirst("b");
        ad1.printDeque();

        System.out.println();

        ad1.removeFirst();
        ad1.removeLast();
        ad1.printDeque();

        assertTrue(ad1.isEmpty());
    }

    /*
    @Test
    public void addTest() {

        ArrayDeque ad1 = new ArrayDeque(5);

        assertTrue("A newly initialized LLDeque should be empty", ad1.isEmpty());

        ad1.addFirst(1);

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, ad1.getSize());
        assertFalse("ad1 should now contain 1 item", ad1.isEmpty());

        ad1.addLast(2);
        assertEquals(2, ad1.getSize());

        ad1.addLast(3);
        assertEquals(3, ad1.getSize());

        System.out.println("Printing out deque: ");
        ad1.printDeque();

    }
     */
    /*
    @Test
    public void addRemoveTest() {

        ArrayDeque ad1 = new ArrayDeque(5);
        // should be empty
        assertTrue("lld1 should be empty upon initialization", ad1.isEmpty());

        ad1.addFirst(10);
        ad1.addLast(11);
        // should not be empty
        assertFalse("lld1 should contain 1 item", ad1.isEmpty());

        ad1.deleteFirst();
        ad1.deleteLast();
        // should be empty
        assertTrue("lld1 should be empty after removal", ad1.isEmpty());
    } */
}
