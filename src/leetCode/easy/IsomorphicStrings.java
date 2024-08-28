package leetCode.easy;

/**
 * 205. Isomorphic Strings
 * Solved
 * Easy
 * Topics
 * Companies
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        int [] mapS = new int[256];
        int [] mapT = new int[256];

        for(int i=0; i<s.length();i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // If the mapping doesn't match the previous mappings, return false
            if(mapS[c1] != 0 && mapS[c1] != c2 || mapT[c2] != 0 && mapT[c2] != c1) {
                return false;
            }

            mapS[c1] = c2;
            mapT[c2] = c1;
        }
        return true;
    }
}
