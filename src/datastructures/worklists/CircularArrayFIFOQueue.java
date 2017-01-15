package datastructures.worklists;

import java.util.NoSuchElementException;

import cse332.exceptions.NotYetImplementedException;
import cse332.interfaces.worklists.FixedSizeFIFOWorkList;

/**
 * See cse332/interfaces/worklists/FixedSizeFIFOWorkList.java
 * for method specifications.
 */
public class CircularArrayFIFOQueue<E> extends FixedSizeFIFOWorkList<E> {
	
	private E[] queue;
//	private static final int DEFAULT_CAP = 100;
	private int front, back, size;
	
    public CircularArrayFIFOQueue(int capacity) {
        super(capacity);
        front = back = size = 0;
        queue = (E[]) new Comparable[capacity];
//        throw new NotYetImplementedException();
    }

    /**
     * Adds work to the worklist. This method should conform to any additional
     * contracts that the particular type of worklist has.
     *
     * @precondition isFull() is false
     *
     * @param work
     *            the work to add to the worklist
     * @throws IllegalStateException
     *             iff isFull()
     */
    @Override
    public void add(E work) {
    	if (isFull()) {
    		throw new IllegalStateException("Queue is full!");
    	}
    	queue[back] = work;
    	size++;
    	back = (back + 1) % queue.length;
//        throw new NotYetImplementedException();
    }

    /**
     * Returns a view of the ith element of the worklist. Since this worklist is
     * a FIFO worklist, it has a well-defined order.
     *
     * @precondition 0 <= i < size()
     * @postcondition the structure of this worklist remains unchanged
     * @throws NoSuchElementException
     *             if hasWork() is false (this exception takes precedence over
     *             all others)
     * @throws IndexOutOfBoundsException
     *             if i < 0 or i >= size()
     *
     * @param i
     *            the index of the element to peek at
     * @return the ith element in this worklist
     */
    @Override
    public E peek() {
    	if (!hasWork()) {
    		throw new NoSuchElementException();
    	}
    	return queue[front];
//        throw new NotYetImplementedException();
    }
    
    @Override
    public E peek(int i) {
    	if (!hasWork()) {
    		throw new NoSuchElementException();
    	}
    	if (i < 0 || i > size() - 1) {
    		throw new NoSuchElementException();
    	}
    	return queue[(front + 1) % queue.length];
//        throw new NotYetImplementedException();
    }
    
    @Override
    public E next() {
    	if (!hasWork()) {
    		throw new NoSuchElementException();
    	}
    	E temp = queue[front];
    	if (front == queue.length - 1) {
    		front = 0;
    	} else {
    		front++;
    	}
    	size--;
    	return temp;
//        throw new NotYetImplementedException();
    }
    
    @Override
    public void update(int i, E value) {
    	if (i < 0 || i > size() - 1) {
    		throw new NoSuchElementException();
    	}
    	queue[i] = value;
//        throw new NotYetImplementedException();
    }
    
    @Override
    public int size() {
    	return size;
//        throw new NotYetImplementedException();
    }
    
    @Override
    public void clear() {
    	front = back = size = 0;
//        throw new NotYetImplementedException();
    }
    
    public String toString() {
    	if (!hasWork()) {
    		return "[]";
    	}
    	String result = "[" + queue[front].toString();
    	for (int i = front + 1; i < back; i++) {
    		result += ", " + queue[i].toString();
    	}
    	return result += "]";
    }

    @Override
    public int compareTo(FixedSizeFIFOWorkList<E> other) {
        // You will implement this method in p2. Leave this method unchanged for p1.
        throw new NotYetImplementedException();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        // You will finish implementing this method in p2. Leave this method unchanged for p1.
        if (this == obj) {
            return true;
        }
        else if (!(obj instanceof FixedSizeFIFOWorkList<?>)) {
            return false;
        }
        else {
            FixedSizeFIFOWorkList<E> other = (FixedSizeFIFOWorkList<E>) obj;

            // Your code goes here

            throw new NotYetImplementedException();
        }
    }

    @Override
    public int hashCode() {
        // You will implement this method in p2. Leave this method unchanged for p1.
        throw new NotYetImplementedException();
    }
	
}
