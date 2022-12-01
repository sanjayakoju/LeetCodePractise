package leetCode.easy;

/**
 * You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.
 *
 * Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.
 *
 * Return true if a and b are alike. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "book"
 * Output: true
 * Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
 * Example 2:
 *
 * Input: s = "textbook"
 * Output: false
 * Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
 * Notice that the vowel o is counted twice.
 *
 *
 * Constraints:
 *
 * 2 <= s.length <= 1000
 * s.length is even.
 * s consists of uppercase and lowercase letters.
 */
public class DetermineIfStringHalvesAreAlike {
    public static boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        char ch[] = s.toCharArray();
        if (ch.length % 2 != 0) {
            return false;
        }

        int i = 0;
        int j = ch.length - 1;
        int count1 = 0;
        int count2 = 0;
        while(i < j) {
            if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u') {
                count1++;
            }
            if (ch[j] == 'a' || ch[j] == 'e' || ch[j] == 'i' || ch[j] == 'o' || ch[j] == 'u') {
                count2++;
            }
            i++;
            j--;
        }

        if(count1 == count2) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "textbook";
        System.out.println(halvesAreAlike(str));
    }
}
