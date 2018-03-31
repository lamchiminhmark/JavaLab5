import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class MRUListTest {

    @Test
    public void testAddT() {
	MRUList<Integer> test = new MRUList<Integer>();
	ArrayList<Integer> standard = new ArrayList<Integer>();

	for (int i = 0; i <= 8; i++) {
	    test.add(i);
	}

	for (int i = 8; i >= 0; i--) {
	    standard.add(i);
	}

	for (int i = 0; i < test.size(); i++) {
	    assertEquals("The element", standard.get(i), test.get(i));
	}

	assertEquals("The size", standard.size(), test.size());
    }

    @Test
    public void testAddIntT() {
	MRUList<Integer> test = new MRUList<Integer>();
	ArrayList<Integer> standard = new ArrayList<Integer>();

	for (int i = 0; i <= 8; i++) {
	    test.add(2, i);
	}

	for (int i = 8; i >= 0; i--) {
	    standard.add(i);
	}

	for (int i = 0; i < test.size(); i++) {
	    assertEquals("The element", standard.get(i), test.get(i));
	}

	assertEquals("The size", standard.size(), test.size());
    }

    @Test
    public void testContainsObject() {
	MRUList<Integer> test = new MRUList<Integer>();
	ArrayList<Integer> standard = new ArrayList<Integer>();

	for (int i = 0; i <= 8; i++) {
	    test.add(i);
	}

	assertTrue("Cannot find 3.", test.contains(3));

	standard.add(3);
	for (int i = 8; i >= 4; i--) {
	    standard.add(i);
	}

	for (int i = 2; i >= 0; i--) {
	    standard.add(i);
	}

	for (int i = 0; i < test.size(); i++) {
	    assertEquals("The element", standard.get(i), test.get(i));
	}
    }

    @Test
    public void testIndexOfObject() {
	MRUList<Integer> test = new MRUList<Integer>();
	ArrayList<Integer> standard = new ArrayList<Integer>();

	for (int i = 0; i <= 10000; i++) {
	    test.add(i);
	}

	assertEquals("Index of 3", 9997, test.indexOf(3));

	standard.add(3);
	for (int i = 10000; i >= 4; i--) {
	    standard.add(i);
	}

	for (int i = 2; i >= 0; i--) {
	    standard.add(i);
	}

	for (int i = 0; i < test.size(); i++) {
	    assertEquals("The element", standard.get(i), test.get(i));
	}
    }

}
