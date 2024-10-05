package coreJava;

import java.util.LinkedList;

class CustomHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16; // Default size
    private LinkedList<Entry<K, V>>[] buckets;
    private int size; // Number of elements

    // Entry class to store key-value pairs
    static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor to initialize the map with default capacity
    public CustomHashMap() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public CustomHashMap(int capacity) {
        buckets = new LinkedList[capacity];
        size = 0;
    }

    // Hash function to calculate index
    private int hash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode() % buckets.length);
    }

    // Put method
    public void put(K key, V value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        // Check if the key already exists
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update value if key exists
                return;
            }
        }

        // Add new entry if key doesn't exist
        buckets[index].add(new Entry<>(key, value));
        size++;
    }

    // Get method
    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        if (bucket != null) {
            for (Entry<K, V> entry : bucket) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null; // Return null if key not found
    }

    // Size of the map
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("orange", 3);

        System.out.println("apple: " + map.get("apple")); // Output: 1
        System.out.println("banana: " + map.get("banana")); // Output: 2
        System.out.println("grape: " + map.get("grape")); // Output: null
        System.out.println("Size: " + map.size()); // Output: 3
    }
}

