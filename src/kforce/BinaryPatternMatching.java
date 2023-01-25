package kforce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryPatternMatching {

    public static int matchPattern(String pattern, String source) {
        int match = 0;
        int patternLength = pattern.length();
        List<String> list = new ArrayList<>();
        for (int i=0;i<=source.length() - patternLength;i++) {
            list.add(source.substring(i,i+patternLength));
        }
        Map<Character,Character> map = getVowel();
        char vowel = 0;
        for (String st: list) {
            boolean matched = false;
            for (int i=0;i<patternLength;i++) {
                vowel = map.containsKey(st.charAt(i)) ? map.get(st.charAt(i)) : '1';
                matched = pattern.charAt(i) == vowel;
                if (!matched) break;
            }
            if (matched) match++;
        }
        return match;
    }

    public static Map<Character, Character> getVowel() {
        Map<Character,Character> map = new HashMap<>();
        map.put('a','0');
        map.put('e','0');
        map.put('i','0');
        map.put('o','0');
        map.put('u','0');
        map.put('y','0');
        return map;
    }

    public static void main(String[] args) {
        String pattern = "010";
        String source = "amazing";
        System.out.println(matchPattern(pattern, source));
    }
}
