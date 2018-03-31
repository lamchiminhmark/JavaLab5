
/*
 * DoublyLinkedList
 * 
 * This class implements the Java List interface using a doubly-linked list.
 * 
 * A nested ListNode class is included.
 * 
 */
import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> extends AbstractList<T> {
    int size;
    ListNode header, trailer;
    private int modCount; // for iterator data
    /*
     * ListNode
     * 
     * This nested class represents one node in a doubly linked list.
     */

    protected class ListNode {
	T datum;
	ListNode prior, next;

	ListNode() {
	    this(null);
	}

	ListNode(T data) {
	    this(data, null, null);
	}

	ListNode(T data, ListNode prior, ListNode next) {
	    this.datum = data;
	    this.prior = prior;
	    this.next = next;
	}
    } // end of class ListNode

    /*
     * Constructs an empty list.
     */
    DoublyLinkedList() {
	/*
	 * TODO: Write a constructor here The empty list has two sentinel nodes, a
	 * header and a trailer, linked to each other
	 */

	header = new ListNode(null, null, trailer);
	trailer = new ListNode(null, header, null);
	size = 0;
    }

    /*
     * Returns a reference to the nth node in the list.
     */
    private ListNode getNthNode(int n) {
	/* TODO: Write the getNthNode method */
	ListNode p = header.next;
	if (n < 0 || n >= size) {
	    throw new IndexOutOfBoundsException();
	}
	for (int i = 0; i < n; i++) {
	    p = p.next;
	}
	return p; // replace this line
    }

    /*
     * Returns a count of the number of elements in the list.modCount++
     */
    public int size() {
	return size;
    }

    /*
     * Returns the data item at the given position in the list.
     */
    public T get(int position) {
	// TODO: Write the get method
	return getNthNode(position).datum; // replace this to return the element at given position
    }

    /*
     * Replaces the item at the given position with the given data item. The return
     * value is the element that is replaced.
     */
    public T set(int position, T data) {
	// TODO: Write the set method
	if (data == null) {
	    throw new NullPointerException();
	}
	ListNode temp = getNthNode(position);
	T tempData = temp.datum;
	temp.datum = data;
	return tempData;// replace this so the replaced element is returned
    }

    /*
     * Inserts the given data item at the end of the list.
     */
    public boolean add(T data) {
	// TODO: Write a method to add data to the end of the list
	ListNode newNode = new ListNode(data, trailer.prior, trailer);
	trailer.prior.next = newNode;
	trailer.prior = newNode;
	if (this.isEmpty()) {
	    header.next = newNode;
	}
	size++;
	modCount++; // for concurrent modifications needed for the Iterator class
	if (data == null) {
	    throw new NullPointerException();
	}
	return true;
    }

    /*
     * Inserts the given data item at the given position in the list.
     */
    public void add(int position, T data) {
	// TODO: Write a method to add data at the given position in the list
	if (data == null) {
	    throw new NullPointerException();
	}
	/*
	 * 
	 * @@@@@@@@ Added if block to account for empty lists.
	 * 
	 */
	if (!isEmpty()) {
	    ListNode target = getNthNode(position);
	    ListNode newNode = new ListNode(data, target.prior, target);
	    target.prior.next = newNode;
	    target.prior = newNode;
	} else {
	    ListNode newNode = new ListNode(data, header, trailer);
	    header.next = newNode;
	    trailer.prior = newNode;
	}

	size++;
	modCount++; // for concurrent modifications needed for the Iterator class

    }

    /*
     * Removes the element at a given index in the list.
     */
    public T remove(int index) {
	// TODO: Write the remove method
	T target;
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
	} else {
	    ListNode prior = getNthNode(index - 1);
	    target = prior.next.datum;
	    prior.next = prior.next.next;
	    prior.next.prior = prior;
	}
	size--;
	modCount++; // for concurrent modifications needed for the Iterator class
	return target; // replace this line so the removed item is returned
    }

    /*
     * Searches the list for the given object
     */
    public boolean contains(Object obj) {
	// TODO: Write the contains method
	ListNode p = header.next;
	while (p != trailer) {
	    if (p.datum.equals(obj)) {
		return true;
	    }
	    p = p.next;
	}
	return false; // replace this line to return the result of the search
    }

    /*
     * Returns the position of the given object
     */
    public int indexOf(Object obj) {
	// TODO: Write the contains method
	int index = 0;
	ListNode p = header.next;
	while (p != trailer) {
	    if (p.datum.equals(obj)) {
		return index;
	    }
	    p = p.next;
	    index++;
	}
	return -1; // replace this line to return the position of obj
    }

    /*
     * Deletes all elements from the list.
     */
    public void clear() {
	header.next = trailer;
	trailer.prior = header;
	size = 0;
	modCount++; // for concurrent modifications needed for the Iterator class
	// TODO: Write the clear method
    }

    /*
     * Determines if the list is empty.
     */
    public boolean isEmpty() {
	return size == 0;
    }

    /*
     * Returns an iterator for this list
     */
    class DoublyLinkedListIterator implements Iterator<T> {

	private ListNode cursor;
	int index; // useful to keep track of index
	private int currentModCount = modCount;

	DoublyLinkedListIterator() {
	    cursor = header;
	    int index = -1;
	}

	@Override
	public boolean hasNext() {
	    if (currentModCount != modCount) {
		throw new ConcurrentModificationException("Concurrent modification is made while Iterator is running.");
	    } else if (!cursor.next.equals(trailer)) {
		return true;
	    }
	    return false;
	}

	@Override
	public T next() {
	    if (currentModCount != modCount) {
		throw new ConcurrentModificationException("Concurrent modification is made while Iterator is running.");
	    } else if (!hasNext())
		throw new NoSuchElementException("There is no next elements.");
	    cursor = cursor.next;
	    T target = cursor.datum;
	    index++; // useful to keep track of index
	    return target;
	}

	public void remove() {
	    if (currentModCount != modCount) {
		throw new ConcurrentModificationException("Concurrent modification is made while Iterator is running.");
	    } else if (cursor.equals(header)) {
		throw new IllegalStateException("Next has not been called.");
	    }
	    cursor.next.prior = cursor.prior;
	    cursor.prior.next = cursor.next;
	    // @@@@@@ Changed here
	    cursor = cursor.prior;
	    //
	    currentModCount++;
	    modCount++;
	    // @@@@@@ Added this
	    size--;
	    //
	}
    }

    public Iterator<T> iterator() {
	// TODO: Write the iterator method
	DoublyLinkedListIterator iterator = new DoublyLinkedListIterator();

	return iterator; /* replace this line */
    }
}
