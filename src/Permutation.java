import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * [1,2,3] input
 * [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1];
 */
public class Permutation {

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static List<List<Integer>> getPermutation(int [] arr, int l, int r) {

        List<List<Integer>> finalResult = new ArrayList<>();
        if (l == r) {
           List<Integer> myList = new ArrayList<>();
           for (int num: arr) {
               myList.add(num);
           }
           finalResult.add(myList);
        } else {
            for(int i=l; i<=r; i++) {
                swap(l, i, arr);
                finalResult.addAll(getPermutation(arr, l + 1, r));
                swap(l, i, arr);
            }
        }

        return finalResult;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3};
        System.out.println(getPermutation(arr, 0, arr.length -1));

        sortMap();
    }

    private static void sortMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 3);
        map.put("banana", 2);
        map.put("cherry", 1);

        // Sort by values in ascending order
        Map<String, Integer> result = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())  // Sort by value
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));

        System.out.println(result);

        Map<Integer, String> maps = new HashMap<>();
        maps.put(1, "Apple");
        maps.put(2, "Banana");
        maps.put(3, "Cherry");

        // Stream over map entries and filter
        maps.entrySet()
                .stream()
                .filter(entry -> entry.getKey() % 2 == 0) // filter even keys
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));


        Map<Integer, String> transformedMap = maps.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey() * 2,       // transform key
                        entry -> entry.getValue().toUpperCase() // transform value
                ));

        transformedMap.forEach((k, v) -> System.out.println(k + ": " + v));

        List<String> words = Arrays.asList("apple", "banana", "cherry", "apricot");

        Map<Character, List<String>> groupedByFirstLetter = words.stream()
                .collect(Collectors.groupingBy(word -> word.charAt(0)));

        // Result: {a=[apple, apricot], b=[banana], c=[cherry]}


    }

}

