package assessment.amazon;

public class ResultOATwo {

        public static String getSpecialString(String s) {
            char[] arr = s.toCharArray();
            int n = arr.length;

            for (int i = n - 2; i >= 0; i--) {
                if (arr[i] < 'z') {
                    arr[i]++;
                    for (int j = i + 1; j < n; j++) {
                        arr[j] = 'a';
                    }
                    if (isSpecial(arr)) {
                        return new String(arr);
                    }
                }
            }
            return "-1";
        }

        private static boolean isSpecial(char[] arr) {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == arr[i - 1]) {
                    return false;
                }
            }
            return true;
        }


    public static String getSpecialString1(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < 'z') {
                arr[i]++;

                // Reset characters after i to ensure a valid lexicographical order
                for (int j = i + 1; j < n; j++) {
                    arr[j] = (arr[j - 1] == 'a') ? 'b' : 'a';
                }
                return new String(arr);
            }
        }
        return "-1";
    }

        public static void main(String[] args) {
            System.out.println(getSpecialString("abccde")); // Expected Output: "abcdab"
            System.out.println(getSpecialString1("abccde")); // Expected Output: "abcdab"
            System.out.println(getSpecialString("zzab"));   // Expected Output: "-1"
            System.out.println(getSpecialString1("zzab"));   // Expected Output: "-1"
        }


}
