package leetCode.medium;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 */
public class PermutationInString {

    public  static boolean checkInclusion(String s1, String s2) {

        // Time complexity: O (n3 * n log n)
        // char[] st1Arr = s1.toCharArray();
        // Arrays.sort(st1Arr);
        // String st1Sorted = new String(st1Arr);

        // int len2 = s2.length();
        // for(int i=0;i<len2;i++) {
        //     for(int j=i;j<len2;j++) {
        //         char[] st2Arr = s2.substring(i, j +1).toCharArray();
        //         Arrays.sort(st2Arr);
        //         String subSorted = new String(st2Arr);
        //         if(subSorted.equals(st1Sorted)) {
        //             return true;
        //         }
        //     }
        // }

        // Time complexity : O(n * m)
        // Map<Character, Integer> map1 = new HashMap<>();
        // for(char c: s1.toCharArray()) {
        //     map1.put(c , map1.getOrDefault(c, 0) + 1);
        // }
        // int need = map1.size();
        // int len2 = s2.length();
        // for(int i =0; i< len2;i++) {
        //     Map<Character, Integer> map2 = new HashMap<>();
        //     int count = 0;
        //     for(int j=i;j<len2;j++) {
        //         char c = s2.charAt(j);
        //         map2.put(c, map2.getOrDefault(c, 0) +1);

        //         if(map1.getOrDefault(c, 0) < map2.get(c))
        //             break;

        //         if(map1.getOrDefault(c, 0) == map2.get(c))
        //             count++;

        //         if(count == need)
        //             return true;
        //     }
        // }
        // return false;

        // Time complexity: O(1)
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
            }
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) {
                return true;
            }

            int index = s2.charAt(r) - 'a';
            s2Count[index]++;
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] + 1 == s2Count[index]) {
                matches--;
            }

            index = s2.charAt(l) - 'a';
            s2Count[index]--;
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] - 1 == s2Count[index]) {
                matches--;
            }
            l++;
        }
        return matches == 26;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("abc", "zxsacbswe"));
    }
}
