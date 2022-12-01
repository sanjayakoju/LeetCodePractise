package leetCode.easy;

public class Palindrome {
    public static boolean isPalindrome(int num) {
        int temp = num;
        int rev = 0;
        int rem;
        while(num != 0) {
            rem = num % 10;
            rev = rev * 10 + rem;
            num = num / 10;
        }
        if (temp == rev)
            return  true;
        return false;
    }

    public static void main(String[] args) {
        int n = 12321;
        System.out.println(isPalindrome(n));
    }
}
