package tt;

import java.util.ArrayList;
import java.util.List;

public class TrucksWeightProblem {

    // This is the incorrect solution, the program is not outputting correct value.
    // Ignore this: Understand question and re-write optimal solution
    public static List<Integer> getTrucksForItems(int[] trucks, int[] items) {
        List<Integer> assignedTrucks = new ArrayList<>();

        for (int item : items) {
            int minTruckIndex = -1; // Start with -1, indicating no truck found yet
            int minTruckCapacity = Integer.MAX_VALUE; // Start with max value to find the smallest capacity

            for (int j = 0; j < trucks.length; j++) {
                // Check if the truck can carry the item and has a smaller capacity than the current min
                if (trucks[j] > item && trucks[j] < minTruckCapacity) {
                    minTruckCapacity = trucks[j];
                    minTruckIndex = j;
                }
            }

            // Add the found truck index or -1 if no truck can carry the item
            assignedTrucks.add(minTruckIndex);
        }

        return assignedTrucks;
    }
//
    public static void main(String[] args) {
        // Test cases
        int[] trucks1 = {4, 5, 7, 2};
        int[] items1 = {1, 2, 5};
        System.out.println(getTrucksForItems(trucks1, items1)); // Output should be [0, 1, 2]

        int[] trucks2 = {5, 3, 8, 1};
        int[] items2 = {6, 10};
        System.out.println(getTrucksForItems(trucks2, items2)); // Output should be [-1, -1] as none can carry 10 and only truck 2 can carry 6
    }
}
