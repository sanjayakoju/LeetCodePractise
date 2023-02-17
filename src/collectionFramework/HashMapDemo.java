package collectionFramework;

import java.util.HashMap;

public class HashMapDemo {

	public static void main(String[] args) {
		HashMap<String, Integer> hashMap = new HashMap<>();
		hashMap.put("Math", 90);
		hashMap.put("Science", 80);
		hashMap.put("Ea", 10);
		hashMap.put("FB", 10);
		System.out.println(hashMap);
	}
}
