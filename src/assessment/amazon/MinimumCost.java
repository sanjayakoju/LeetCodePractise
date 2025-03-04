package assessment.amazon;

import java.util.List;

public class MinimumCost {

    public long minCost(String password, String reference, List<Integer> cost) {
        // Frequency arrays for password and reference
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Calculate frequency of characters in password
        for (char c : password.toCharArray()) {
            freq1[c - 'a']++;
        }

        // Calculate frequency of characters in reference
        for (char c : reference.toCharArray()) {
            freq2[c - 'a']++;
        }

        long ans = Long.MAX_VALUE;

        // Loop through all 26 characters
        for (int i = 0; i < 26; i++) {
            if (freq2[i] == 0) {
                continue;  // Skip characters not in reference
            }
            if (freq1[i] < freq2[i]) {
                return 0;  // If password has fewer characters than needed
            }
            // Calculate cost using List instead of array
            ans = Math.min(ans, (long) (freq1[i] - freq2[i] + 1) * cost.get(i));
        }

        return ans;
    }
}
