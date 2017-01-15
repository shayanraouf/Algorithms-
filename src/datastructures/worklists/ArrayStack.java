package datastructures.worklists;

import java.util.NoSuchElementException;



import cse332.exceptions.NotYetImplementedException;
import cse332.interfaces.worklists.LIFOWorkList;

/**
 * See cse332/interfaces/worklists/LIFOWorkList.java
 * for method specifications.
 */
public class ArrayStack<E> extends LIFOWorkList<E> {

	private static final int DEFAULT_CAP = 10;
	private int size;
	private int capacity;
	private E[] stack;
	
    public ArrayStack() {
    	size = 0;
    	capacity = DEFAULT_CAP;
    	stack = (E[]) new Object[capacity];
//        throw new NotYetImplementedException();
    }

    @Override
    public void add(E work) {
    	if (size == capacity) {
    		growArray();
    	}
    	stack[size] = work;
    	size++;
//        throw new NotYetImplementedException();
    }

    @Override
    public E peek() {
    	checkNext();
    	return stack[size - 1];
//        throw new NotYetImplementedException();
    }

    @Override
    public E next() {
    	checkNext();
    	E data = stack[size - 1];
    	size--;
    	return data;
//        throw new NotYetImplementedException();
    }

    @Override
    public int size() {
    	return size;
//        throw new NotYetImplementedException();
    }

    @Override
    public void clear() {
    	size = 0;
//        throw new NotYetImplementedException();
    }
    
    private void checkNext() {
    	if (!hasWork()) {
    		throw new NoSuchElementException();
    	}
    }
    
    private void growArray() {
    	int newCapacity = capacity * 2;
    	E[] newStack = (E[]) new Object[newCapacity];
    	for (int i = 0; i < size(); i++) {
    		newStack[i] = stack[i];
    	}
		stack = newStack;
    	capacity = newCapacity;
    }
    
    public String toString() {
    	String result = "[";
    	if (size() == 0) {
    		return result + "]";
    	}
    	result += stack[0];
    	for (int i = 1; i < size(); i++) {
    		result += ", " + stack[i].toString();
    	}
    	return result + "]";
    }
}
