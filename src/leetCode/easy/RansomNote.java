package leetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length())
            return false;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        char ch1[] = ransomNote.toCharArray();
        char ch2[] = magazine.toCharArray();

        for (int i = 0; i<ch1.length;i++) {
            if (map1.containsKey(ch1[i]))
                map1.put(ch1[i], map1.get(ch1[i]) + 1);
            else
                map1.put(ch1[i], 1);
        }

        for (int j = 0; j<ch2.length;j++) {
            if (map2.containsKey(ch2[j]))
                map2.put(ch2[j], map2.get(ch2[j]) + 1);
            else
                map2.put(ch2[j], 1);
        }

        for(Map.Entry<Character, Integer> e: map1.entrySet()) {
            int a = e.getValue();
            char b = e.getKey();
            int c =(map2.get(b) != null) ? map2.get(b) : 0;
            if (c == 0 || a > c)
                return false;

        }

        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "b";
        System.out.println(canConstruct(ransomNote, magazine));
    }
}
