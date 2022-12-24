package kforce;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsBeautifulString {

    private static boolean isBeautifulString(String st) {
        st = st.toLowerCase();
        char ch[] = st.toCharArray();
        Arrays.sort(ch);
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0;i< ch.length;i++) {
            if(map.containsKey(ch[i])) {
                map.put(ch[i], map.get(ch[i]) + 1);
            } else {
                map.put(ch[i], 1);
            }
        }
        int alphaFirst = (int) 'a';
        int alphaLast = (int) 'z';
        int prev = Integer.MAX_VALUE;
        for (int i = alphaFirst; i<= alphaLast;i++) {
            int count;
            if (map.containsKey((char) i)) {
                count = map.get((char) i);
            } else {
                count = 0;
            }
            if (count > prev) return false;
            prev = count;
        }
        return true;
    }

    public static void main(String[] args) {
        String st = "bbbaacdafe";
        System.out.println(isBeautifulString(st));
    }
}
