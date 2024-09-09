package leetCode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * Design an algorithm to encode a list of strings to a string.
 * The encoded string is then sent over the network and is decoded back to the original list of strings.
 * Example
 * Example1
 *
 * Input: ["lint","code","love","you"]
 * Output: ["lint","code","love","you"]
 * Explanation:
 * One possible encode method is: "lint:;code:;love:;you"
 * Example2
 *
 * Input: ["we", "say", ":", "yes"]
 * Output: ["we", "say", ":", "yes"]
 * Explanation:
 * One possible encode method is: "we:;say:;:::;yes"
 */
public class EncodeAndDecodeStrings {

    public static String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            encodedString.append(str.length()).append("#").append(str);
        }
        return encodedString.toString();
    }

    public static List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#')
                j++;

            int length = Integer.parseInt(String.valueOf(str.charAt(i)));
            i = j + 1 + length; // update i
            list.add(str.substring(j + 1, i));
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(encode(List.of("Abc","defgg", "fgt")));
        System.out.println(decode("3#Abc5#defgg3#fgt"));
    }
}
