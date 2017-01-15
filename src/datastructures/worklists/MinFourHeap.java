package datastructures.worklists;

import cse332.interfaces.worklists.PriorityWorkList;

import java.util.NoSuchElementException;

import cse332.exceptions.NotYetImplementedException;

/**
 * See cse332/interfaces/worklists/PriorityWorkList.java
 * for method specifications.
 */
public class MinFourHeap<E extends Comparable<E>> extends PriorityWorkList<E> {
    /* Do not change the name of this field; the tests rely on it to work correctly. */
    private E[] data;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAP = 100;
    private static final int HEAP_SIZE = 4;
    public MinFourHeap() {
    	data = (E[]) new Comparable[DEFAULT_CAP];
    	capacity = DEFAULT_CAP;
//        throw new NotYetImplementedException();
    }

    @Override
    public boolean hasWork() {
    	return size != 0;
//        throw new NotYetImplementedException();
    }

    @Override
    public void add(E work) {
    	if (size + 1 == capacity) {
    		growArray();
    	}
    	data[size] = work;
    	size++;
    	int childIndex = size - 1;
    	int parentIndex = (int) Math.floor((childIndex - 1) / 4);
		//        throw new NotYetImplementedException();
    	while (childIndex > 0) {
    		if (data[childIndex].compareTo(data[parentIndex]) >= 0) {
    			break;
    		}
    		E temp = data[parentIndex];
    		data[parentIndex] = data[childIndex];
    		data[childIndex] = temp;
    		childIndex = parentIndex;
    		parentIndex = (int) Math.floor((childIndex - 1) / 4);
    	}
    }

    @Override
    public E peek() {
    	checkNext();
    	return data[0];
//        throw new NotYetImplementedException();
    }

    @Override
    public E next() {
    	checkNext();
    	E removed = data[0];
    	data[0] = data[size - 1];
    	size--;
    	int parentIndex = 0;
//    	int firstChildIndex =  4 * index + 1;
//    	int secondChildIndex = 4 * index + 2;
//    	int thirdChildIndex =  4 * index + 3;
//    	int fourthChildIndex = 4 * index + 4;
//    	
//    	while (data[index].compareTo(data[firstChildIndex]) > 0 || data[index].compareTo(data[secondChildIndex]) > 0 || data[index].compareTo(data[thirdChildIndex]) > 0 || data[index].compareTo(data[fourthChildIndex]) > 0 ){
//    		
//    	}
    	
    	int[] children = new int[4];
    	for (int i = 0; i < 4; i++) { // Initialize the array of child indices.
    		children[i] = 4 * parentIndex + i + 1;
    	}
    	
    	int minIndex = children[0];
    	while (children[0] < size) {
    		int test = size() - children[0];
        	for (int i = 0; i < Math.min(HEAP_SIZE, size() - children[0]); i++) {
        		if (data[minIndex].compareTo(data[children[i]]) > 0) {
        			minIndex = children[i];
        		}
        	}
        	if (data[parentIndex].compareTo(data[minIndex]) <= 0) {
        		break;
        	}
        	E temp = data[parentIndex];
        	data[parentIndex] = data[minIndex];
        	data[minIndex] = temp;
        	parentIndex = minIndex;
        	for (int i = 0; i < 4; i++) {
        		children[i] = 4 * parentIndex + i + 1;
        	}
        	minIndex = children[0];
    	}   	  	    	
    	return removed;
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
    	E[] newArray = (E[]) new Comparable[newCapacity];
    	for (int i = 0; i < size(); i++) {
    		newArray[i] = data[i];
    	}
		data = newArray;
    	capacity = newCapacity;
    }
    
    public String toString() {
    	String result = "[";
    	if (!hasWork()) {
    		return result + "]";
    	}
    	result += data[0];
    	for (int i = 1; i < size(); i++) {
    		result += ", " + data[i];
    	}
    	return result += "]";
    }
}
