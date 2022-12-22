package leetCode.easy;

import java.util.*;

public class AutoCorrectPrototype {

    public static List<List<String>> anagrams(String words[] , String queries[]) {
        List<List<String>> lists = new ArrayList<>();

        for(int i=0;i<queries.length;i++) {

            List<String> stringList = new ArrayList<>();
            for (int j=0;j< words.length;j++) {
                boolean isAnagrams = isAnagram(queries[i], words[j]);
                if (isAnagrams) {
                    stringList.add(words[j]);
                }
            }
            Collections.sort(stringList);
            lists.add(stringList);
        }

        return lists;
    }

    public static void main(String[] args) {
        String words[] = {"duel", "speed", "dule", "cars", "ld", "dl"};
        String queries[] = {"spede", "deul","dl"};
        List<List<String>> lists = anagrams(words,queries);
        System.out.println(lists.toString());
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        char ch1[] = s.toCharArray();
        char ch2[] = t.toCharArray();
        if (ch1.length != ch2.length) {
            return false;
        }
        for (int i = 0; i < ch1.length;i++) {
            if(map1.containsKey(ch1[i])) {
                map1.put(ch1[i], map1.get(ch1[i]) + 1);
            } else {
                map1.put(ch1[i], 1);
            }
        }

        for (int i = 0; i < ch2.length;i++) {
            if(map2.containsKey(ch2[i])) {
                map2.put(ch2[i], map2.get(ch2[i]) + 1);
            } else {
                map2.put(ch2[i], 1);
            }
        }
        boolean isContain = false;
        if (map1.size() != map2.size()) {
            return false;
        }
        for(Map.Entry<Character, Integer> e1: map1.entrySet()) {
            int a = (map2.get(e1.getKey()) != null) ? map2.get(e1.getKey()) : 0;
            int b = (e1.getValue() != null ) ? e1.getValue() : 0;

            if ( a == b) {
                isContain = true;
            } else {
                return false;
            }
        }
        return isContain;
    }
}
