package coreJava.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        int a = 10;
        String st = Integer.toString(a);
        System.out.println(st);

        List<List<String>> list = new ArrayList<>();
        list.add(Collections.singletonList("abc"));
        list.add(Collections.singletonList("cde"));
        list.add(Collections.singletonList("cde"));;
        list.set(0, Collections.singletonList("a"));
        System.out.println(list);
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.remove("a");
        map.putIfAbsent("a", "a");
        map.getOrDefault("a", "0");


        List<String> list1 = list.stream()
                .flatMap(f -> f.stream())
                .filter(f -> f.contains("c"))
                .collect(Collectors.toList());

        System.out.println(list1);

        Map<String, Long> strings = list.stream()
                .flatMap(f -> f.stream())
                .filter(f -> f.contains("c"))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        System.out.println(strings);

        List<String> words = Arrays.asList("Hello", "World");

// Using map()
        List<String[]> result = words.stream()
                .map(word -> word.split("")) // Returns a stream of String arrays
                .collect(Collectors.toList());

// Using flatMap()
        List<String> flatResult = words.stream()
                .flatMap(word -> Arrays.stream(word.split(""))) // Flattens the structure
                .collect(Collectors.toList());
        System.out.println(flatResult);


    }
}
