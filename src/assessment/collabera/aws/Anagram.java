package assessment.collabera.aws;


import java.util.Arrays;

/**
 * You are given two strings. Print "YES" if they are anagrams of each other; print "NO" otherwise.
 * Note: Anagrams are words that you spell by rearranging the letters of another word.
 * Example:
 * Input: 4 4 abab aabb
 * Output: YES
 */
public class Anagram {

    /**
     * 1. N is of type int
     * 2. K is of type int
     * 3. Str1 is of type String
     * 4. Str2 is of type String
     * return String
     */
    private static String isAnagram(int n, int k, String st1, String st2) {
        if (n!=k)
            return "NO";

        char[] ch1 = st1.toCharArray();
        char[] ch2 = st2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        System.out.println("CH 1 : "+Arrays.toString(ch1));
        System.out.println("CH 2 : "+Arrays.toString(ch2));

        if (Arrays.equals(ch1, ch2))
            return "YES";
        return "NO";

    }

    public static void main(String[] args) {
        int n = 5;
        int k = 5;
        String st1 = "aabb";
        String st2 = "abab";

        String output = isAnagram(n, k, st1, st2);
        System.out.println("IS Anagram : "+ output);
    }

}
