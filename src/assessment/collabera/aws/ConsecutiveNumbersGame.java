package assessment.collabera.aws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given is a list of 'n' numbers. Take the product of two consecutive numbers in the list. If the product
 * result is divided by 3, replace the element in the list with the product result number. Else, keep the element
 * unchanged. The game is repeatedly played until there are no further changes in the list.
 * Find the number of rounds before the game finally ends.
 * Example:
 * n = 5
 * List: 34 56 20 90 100
 * Round 1: {34 56 1800 9000 100}
 * Round 2: {34 100800 16200000 900000 100}
 * Round 3: {3427200 100800 16200000 90000000 100}
 * No. of rounds: 3
 */
public class ConsecutiveNumbersGame {

    public static int solve(List<Integer> arr) {
        int rounds = 0;
        boolean changed = true;

        while (changed) {
            changed = false;
            List<Integer> tempArr = new ArrayList<>(arr);

            for (int i=0;i<tempArr.size() -1 ;i++) {
                int product = tempArr.get(i) * tempArr.get(i+1);
                if (product % 3 == 0) {
                    arr.set(i, product);
                    changed = true;
                }
            }

            if (changed) {
                rounds++;
            }
        }
        return rounds;
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(34, 56, 20, 90, 100));

        System.out.println("No. of rounds: "+solve(list));
    }
}
