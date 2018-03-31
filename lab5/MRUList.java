import java.util.Iterator;

class MRUList<T> extends DoublyLinkedList<T> {

    MRUList() {
	super();
    }

    public boolean add(T x) {
	super.add(0, x);
	return true;
    }

    public void add(int index, T x) {
	super.add(0, x);
    }

    public boolean contains(Object obj) {
	Iterator<T> iterator = iterator();
	while (iterator.hasNext()) {
	    T current = iterator.next();
	    if (current.equals(obj)) {
		iterator.remove();
		add(current);
		return true;
	    }
	}
	return false;
    }

    public int indexOf(Object obj) {
	Iterator<T> iterator = iterator();
	int index = -1;
	while (iterator.hasNext()) {
	    T current = iterator.next();
	    index++;

	    if (current.equals(obj)) {
		iterator.remove();
		add(current);
		return index;
	    }
	}
	return -1;
    }
}
