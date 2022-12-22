package leetCode.easy;

import java.util.*;

public class DictionaryAnagram {

    public static void main(String[] args) {
        String[] words = new String[]{"duel","speed","dule","cars","deeps"};
        String[] queries = new String[]{"spede","deul"};
        List<List<String>> result = autoCorrect(words,queries);
        System.out.println(result.toString());
    }
    public static List<List<String>> autoCorrect(String[] words, String[] queries){
        List<List<String>> result = new ArrayList<>();
        for(String query: queries){
            List<String> temp = new ArrayList<>();
            for(String word: words){
                if(isAnagram(query,word)){
                    temp.add(word);
                }
            }
            Collections.sort(temp);
            result.add(temp);
        }
        return  result;
    }
    public static boolean isAnagram(String a, String b){
        if(a.length() != b.length()) return false;
        int[] ch = new int[126];
        for(int i = 0; i < a.length();i++){
            ch[a.charAt(i)-'a']++;
            ch[b.charAt(i)-'a']--;
        }
        for(int c : ch){
            if(c>0) return false;
        }
        return true;
    }
}
