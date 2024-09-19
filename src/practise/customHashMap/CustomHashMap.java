package practise.customHashMap;

class CustomHashMap<K, V> {
    private class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private final int SIZE = 16; // Fixed size of hash table
    private Entry<K, V>[] table;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        table = new Entry[SIZE];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public V get(K key) {
        int index = hash(key);
        Entry<K, V> entry = table[index];

        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null; // Key not found
    }

    public void put(K key, V value) {
        int index = hash(key);
        Entry<K, V> newEntry = new Entry<>(key, value);
        Entry<K, V> entry = table[index];

        if (entry == null) {
            table[index] = newEntry;
        } else {
            Entry<K, V> prev = null;
            while (entry != null) {
                if (entry.key.equals(key)) {
                    entry.value = value; // Update existing key
                    return;
                }
                prev = entry;
                entry = entry.next;
            }
            prev.next = newEntry; // Add new entry at the end
        }
    }

    public static void main(String[] args) {
        // Create an instance of CustomHashMap
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        // Put some key-value pairs into the map
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Cherry", 3);
        map.put("Date", 4);
        map.put("Elderberry", 5);

        // Retrieve and print values
        System.out.println("Value for key 'Apple': " + map.get("Apple"));         // Output: 1
        System.out.println("Value for key 'Banana': " + map.get("Banana"));       // Output: 2
        System.out.println("Value for key 'Cherry': " + map.get("Cherry"));       // Output: 3
        System.out.println("Value for key 'Date': " + map.get("Date"));           // Output: 4
        System.out.println("Value for key 'Elderberry': " + map.get("Elderberry"));// Output: 5

        // Update an existing key
        map.put("Banana", 20);
        System.out.println("Updated value for key 'Banana': " + map.get("Banana")); // Output: 20

        // Attempt to retrieve a non-existing key
        System.out.println("Value for key 'Fig': " + map.get("Fig")); // Output: null

        // Demonstrate collision handling
        // Assuming the hash function causes "Apple" and "Pineapple" to collide
        map.put("Pineapple", 6);
        System.out.println("Value for key 'Pineapple': " + map.get("Pineapple")); // Output: 6
        System.out.println("Value for key 'Apple': " + map.get("Apple"));         // Output: 1
    }
}

