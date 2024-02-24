package assessment.scaleai.hireart.teleporterGame;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TeleporterGame {
    static Set<Integer> destinations(String[] teleports, int dieSides, int start, int end) {
        Map<Integer, Integer> mapping = new HashMap<>();
        for (String teleport : teleports) {
            String[] pair = teleport.split(",");
            mapping.put(Integer.valueOf(pair[0]), Integer.valueOf(pair[1]));
        }

        Set<Integer> result = new HashSet<>();

        for (int idx = 1; idx <= dieSides; idx++) {
            int current = start + idx;
            if (current > end) break;
            result.add(mapping.getOrDefault(current, current));
        }
        return result;
    }

    public static void main(String[] argv) {
        String[] teleporters1 = {"3,1", "4,2", "5,10"};
        String[] teleporters2 = {"5,10", "6,22", "39,40", "40,49", "47,29"};
        String[] teleporters3 = {"6,18", "36,26", "41,21", "49,55", "54,52",
                "71,58", "74,77", "78,76", "80,73", "92,85"};
        String[] teleporters4 = {"97,93", "99,81", "36,33", "92,59", "17,3",
                "82,75", "4,1", "84,79", "54,4", "88,53",
                "91,37", "60,57", "61,7", "62,51", "31,19"};
        String[] teleporters5 = {"3,8", "8,9", "9,3"};

        System.out.println(destinations(teleporters1, 6, 0, 20)); // [1, 2, 6, 10]
        System.out.println(destinations(teleporters2, 6, 46, 100)); // [48, 49, 50, 51, 52, 29]
        System.out.println(destinations(teleporters2, 10, 0, 50)); // [1, 2, 3, 4, 22, 7, 8, 9, 10]
        System.out.println(destinations(teleporters3, 10, 95, 100)); // [96, 97, 98, 99, 100]
        System.out.println(destinations(teleporters3, 10, 70, 100)); // [72, 73, 58, 75, 76, 77, 79]
        System.out.println(destinations(teleporters4, 6, 0, 100)); // [1, 2, 3, 5, 6]
        System.out.println(destinations(teleporters5, 6, 0, 20)); // [1, 2, 4, 5, 6, 8]
    }
}
