package assessment.amazon;

public class ResultOAOne {
    public static String findObfuscateMessage(String message) {
        String smallest = message;
        int n = message.length();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String rotated = rotateRight(message, i, j);
                if (rotated.compareTo(smallest) < 0) {
                    smallest = rotated;
                }
            }
        }

        return smallest;
    }

    private static String rotateRight(String s, int start, int end) {
        char[] arr = s.toCharArray();
        char last = arr[end];

        for (int i = end; i > start; i--) {
            arr[i] = arr[i - 1];
        }
        arr[start] = last;

        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(findObfuscateMessage("aahhab")); // Expected Output: "aaahhb"
    }
}

