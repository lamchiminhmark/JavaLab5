import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

public class DoublyLinkedListTest {

    @Test
    public void testSize() {
	DoublyLinkedList<Integer> test = new DoublyLinkedList<Integer>();
	ArrayList<Integer> standard = new ArrayList<Integer>();
	test.add(1);
	test.add(10);
	test.add(100);
	standard.add(1);
	standard.add(10);
	standard.add(100);
	assertEquals("Constructed lists:", standard.size(), test.size());
    }

    @Test
    public void testIsEmpty() {
	DoublyLinkedList<Integer> test = new DoublyLinkedList<Integer>();
	assertTrue("List not empty", test.isEmpty());
	test.add(1);
	assertFalse("List empty", test.isEmpty());
    }

    @Test
    public void testClear() {
	DoublyLinkedList<Integer> test = new DoublyLinkedList<Integer>();
	test.add(1);
	test.add(10);
	test.add(100);
	test.clear();
	assertTrue("List not empty", test.isEmpty());
    }

    @Test
    public void testDoublyLinkedList() {
	fail("Not yet implemented");
    }

    @Test
    public void testGetInt() {
	DoublyLinkedList<Integer> test = new DoublyLinkedList<Integer>();
	test.add(1);
	test.add(10);
	test.add(100);
	if (test.get(1) == null) {
	    System.out.println("yay");
	}
	assertEquals("Index 1:", 10, (int) test.get(1));
    }

    @Test
    public void testSetIntT() {
	DoublyLinkedList<Integer> test = new DoublyLinkedList<Integer>();
	ArrayList<Integer> standard = new ArrayList<Integer>();
	test.add(1);
	test.add(10);
	test.add(100);
	standard.add(1);
	standard.add(10);
	standard.add(100);
	test.set(1, 12);
	standard.set(1, 12);
	for (int i = 0; i < test.size(); i++) {
	    assertEquals("Things: ", standard.get(i), test.get(i));
	}
    }

    @Test
    public void testAddT() {
	DoublyLinkedList<Integer> test = new DoublyLinkedList<Integer>();
	ArrayList<Integer> standard = new ArrayList<Integer>();
	test.add(1);
	test.add(10);
	test.add(100);
	standard.add(1);
	standard.add(10);
	standard.add(100);
	for (int i = 0; i < test.size(); i++) {
	    assertEquals("element:", standard.get(i), test.get(i));
	}
    }

    @Test
    public void testAddIntT() {
	DoublyLinkedList<Integer> test = new DoublyLinkedList<Integer>();
	ArrayList<Integer> standard = new ArrayList<Integer>();
	test.add(1);
	test.add(10);
	test.add(1, 100);
	standard.add(1);
	standard.add(10);
	standard.add(1, 100);
	for (int i = 0; i < test.size(); i++) {
	    assertEquals("element:", standard.get(i), test.get(i));
	}
    }

    @Test
    public void testRemoveInt() {
	DoublyLinkedList<Integer> test = new DoublyLinkedList<Integer>();
	ArrayList<Integer> standard = new ArrayList<Integer>();
	test.add(1);
	test.add(10);
	test.add(100);
	standard.add(1);
	standard.add(10);
	standard.add(100);
	assertEquals("Things:", standard.remove(1), test.remove(1));
	assertEquals("Size:", standard.size(), test.size());

    }

    @Test
    public void testContainsObject() {
	DoublyLinkedList<Integer> test = new DoublyLinkedList<Integer>();
	test.add(1);
	test.add(10);
	test.add(100);
	assertTrue("Contains: ", test.contains(10));
	assertFalse("Contains: ", test.contains(12));

    }

    @Test
    public void testIndexOfObject() {
	DoublyLinkedList<Integer> test = new DoublyLinkedList<Integer>();
	test.add(1);
	test.add(10);
	test.add(100);
	assertEquals("Position of 10 is: ", 1, test.indexOf(10));
	assertEquals("Position of 12 is: ", -1, test.indexOf(12));
    }

    @Test
    public void testIterator() {
	DoublyLinkedList<Integer> test = new DoublyLinkedList<Integer>();
	ArrayList<Integer> standard = new ArrayList<Integer>();
	for (int i = 2; i <= 20; i++) {
	    test.add(i);
	}
	int firstIterator = 1;

	while (test.size() > firstIterator) {
	    Iterator<Integer> iterator = test.iterator();
	    Integer prime = 0;
	    for (int i = 0; i < firstIterator; i++) {
		prime = iterator.next();
	    }
	    while (iterator.hasNext()) {
		if (iterator.next() % prime == 0) {
		    iterator.remove();
		}
	    }
	    firstIterator++;
	}

	standard.add(2);
	standard.add(3);
	standard.add(5);
	standard.add(7);
	standard.add(11);
	standard.add(13);
	standard.add(17);
	standard.add(19);
	for (int i = 0; i < test.size(); i++) {
	    assertEquals("element:", standard.get(i), test.get(i));
	}
    }

    // test exceptions too
}
