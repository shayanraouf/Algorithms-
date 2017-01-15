package datastructures.dictionaries;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import cse332.exceptions.NotYetImplementedException;
import cse332.interfaces.misc.BString;
import cse332.interfaces.trie.TrieMap;

/**
 * See cse332/interfaces/trie/TrieMap.java
 * and cse332/interfaces/misc/Dictionary.java
 * for method specifications.
 */
public class HashTrieMap<A extends Comparable<A>, K extends BString<A>, V> extends TrieMap<A, K, V> {
    public class HashTrieNode extends TrieNode<Map<A, HashTrieNode>, HashTrieNode> {
        public HashTrieNode() {
            this(null);
        }

        public HashTrieNode(V value) {
            this.pointers = new HashMap<A, HashTrieNode>();
            this.value = value;
        }

        @Override
        public Iterator<Entry<A, HashTrieMap<A, K, V>.HashTrieNode>> iterator() {
            return pointers.entrySet().iterator();
        }
    }

    public HashTrieMap(Class<K> KClass) {
        super(KClass);
        this.root = new HashTrieNode();
    }

    @Override
    public V insert(K key, V value) {
    	checkKey(key);
    	this.size++;
    	if (value.equals(null)) {
    		throw new IllegalArgumentException();
    	}
    	HashTrieNode current = (HashTrieNode) this.root;
    	
//    	int i = 0;
//    	for (A letter : key) {
//    		if (i == key.toString().length() - 1) { // Stops one before the final node
//    			break;
//    		}
//    		if (current.pointers.containsKey(letter)) {
//    			current = current.pointers.get(letter);
//    		} else { // does not hold key. Make a new one.
//    			current.pointers.put(letter, null);
//    			current = current.pointers.get(letter);
//    		}
//    	}	
    	
    	for (A letter : key) {
    		if (current.pointers.containsKey(letter)) { // current node does contain letter of alphabet
    			current = current.pointers.get(letter);
    		} else { // Node does not contain letter of alphabet.
    			current.pointers.put(letter, new HashTrieNode());
    			current.pointers.get(letter);
    		}
    	}
    	V old = current.value;
    	current.value = value;
    	return old;
//        throw new NotYetImplementedException();
    }

    @Override
    public V find(K key) {
//    	if (key.equals(null)) {
//    		throw new IllegalArgumentException();
//    	}
    	checkKey(key);
    	HashTrieNode current = (HashTrieNode) this.root;
    	for (A letter : key) {
    		if (current.pointers.containsKey(letter)) {
    			current = current.pointers.get(letter);
    		} else { // Does not contain the key
    			return null;
    		}
    	}
    	return current.value;    	
//        throw new NotYetImplementedException();
    }

    /**
     * findPrefix(Key k) should return true iff k is a prefix of some key in the trie. For example, if “add”
	 * were a key in the trie, then: findPrefix(“”) = findPrefix(“a”) = findPrefix(“ad”) = findPrefix(“add”) = true.
     */
    @Override
    public boolean findPrefix(K key) {
    	// Go until the end. If nothing is left and current node exists, it is a prefix.
    	// Otherwise, it is not and return false.
    	checkKey(key);
    	HashTrieNode current = (HashTrieNode) this.root;
    	for (A letter : key) {
    		if (current.pointers.containsKey(letter)) {
    			current = current.pointers.get(letter);
    		} else {
    			return false;
    		}
    	}
    	return true;
//        throw new NotYetImplementedException();
    }

    @Override
    public void delete(K key) {
    	// Need to stop at one before. 
    	checkKey(key);
    	this.size--;
       // throw new NotYetImplementedException();
    }

    @Override
    public void clear() {
    	this.size = 0; 
    	this.root = new HashTrieNode();
       // throw new NotYetImplementedException();
    }
    
    private void checkKey(K key) {
    	if (key.equals(null)) {
    		throw new IllegalArgumentException();
    	}
    }
}
