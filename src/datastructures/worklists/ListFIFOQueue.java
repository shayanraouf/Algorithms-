package datastructures.worklists;

import java.util.NoSuchElementException;

import cse332.exceptions.NotYetImplementedException;
import cse332.interfaces.worklists.FIFOWorkList;

/**
 * See cse332/interfaces/worklists/FIFOWorkList.java
 * for method specifications.
 */
public class ListFIFOQueue<E> extends FIFOWorkList<E> {
    
	private static class QueueNode<E> {
		
		private QueueNode<E> next;
		public E data;
		
		public QueueNode() {
			this(null, null);
		}
		
		public QueueNode(E data) {
			this(data, null);
		}
		
		public QueueNode(E data, QueueNode<E> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private QueueNode<E> front;
	private QueueNode<E> back;
	private int size;
	
    public ListFIFOQueue() {
    	front = back = null;
    	size = 0;
//        throw new NotYetImplementedException();
    }

    @Override
    public void add(E work) {
    	if (front == null) { // Queue is empty
    		front = new QueueNode<E>(work);
    		back = front;
    	} else {
    		back.next = new QueueNode<E>(work);
    		back = back.next;
    	}
    	size++;
//        throw new NotYetImplementedException();
    }

    @Override
    public E peek() {
    	if (!hasWork()) {
    		throw new NoSuchElementException(); // Not sure if right exception. Cannot use NoSuchElementException
    	}
    	return front.data;
//        throw new NotYetImplementedException();
    }

    @Override
    public E next() {
    	if (!hasWork()) {
    		throw new NoSuchElementException(); // Not sure if right exception. Cannot use NoSuchElementException
    	}
    	QueueNode<E> temp = new QueueNode<E>(front.data);
    	front = front.next;
    	size--;
    	return temp.data;
//        throw new NotYetImplementedException();
    }

    @Override
    public int size() {
    	return size;
//        throw new NotYetImplementedException();
    }

    @Override
    public void clear() {
    	front = back = null;
    	size = 0;
//        throw new NotYetImplementedException();
    }
    
    public String toString() {
    	String result = "[";
    	if (front == null) {
    		return result += "]";
    	}
    	QueueNode curr = front;
    	result += curr.data.toString();
    	for (int i = 1; i < size(); i++) {
    		curr = curr.next;
    		result += ", " + curr.data.toString();
    	}
    	return result + "]";
    }
}
