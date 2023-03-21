package collectionFramework;

import java.util.HashMap;

/**
 * HashMap does not contain the duplicate key but may contains the duplicate value,
 * if we provide the duplicate key then it will replace the previous value. While hashing different object if the
 * hash value belong to the same bucket(Hash Collision) then it will put the data in linked list until linked list become 8.
 * If linked list size is more than 10 then it will used balancing algorithm and put data into balanced tree.
 */
public class HashMapDemo {

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "ABC");
        hashMap.put(10, "BCD");
        System.out.println(hashMap.toString());
        System.out.println(hashMap.get(1));
//        hashMap.remove(1);
        hashMap.remove(1, "ABC");
        System.out.println(hashMap.toString());

        String s = "1";
        int a = Integer.parseInt(s);
        int b = Integer.valueOf(s.toString());
        System.out.println(a);
        System.out.println(b);
    }
}
