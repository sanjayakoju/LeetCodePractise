package leetCode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * leetcode: 472. Concatenated Words
 *
 * Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.
 *
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words (not necessarily distinct) in the given array.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 * "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
 * "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 * Example 2:
 *
 * Input: words = ["cat","dog","catdog"]
 * Output: ["catdog"]
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 104
 * 1 <= words[i].length <= 30
 * words[i] consists of only lowercase English letters.
 * All the strings of words are unique.
 * 1 <= sum(words[i].length) <= 105
 */
public class ConcatenatedWords {

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        set.addAll(Arrays.asList(words));
        // Iterate over the array
        for(String word : words){
            int sz = word.length();
            // Putting flags where the smaller valid string ends
            boolean[] flags = new boolean[sz + 1];
            flags[0] = true;
            //Iterate over the string
            for(int i = 0; i < sz; i++){
                //Skipping already included characters
                if(!flags[i]){
                    continue;
                }
                //Finding substrings which are present in the word array
                for(int k = i + 1; k <= sz; k++){
                    if(k - i < sz && set.contains(word.substring(i, k))){
                        flags[k] = true; // put down the flag where the selected smaller string ends
                    }
                }
                //If the string is successfully made
                //by combination of other strings add it to the result and break out of
                //the loop to avoid adding repeated strings to the result
                if(flags[sz]){
                    result.add(word);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] st = {"cat", "dog", "catdog"};
        System.out.println(findAllConcatenatedWordsInADict(st));
    }
}
