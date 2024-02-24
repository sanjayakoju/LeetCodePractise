package assessment.scaleai.hireart.castleTreasure;

import java.util.*;

public class CastleTreasureFinder {

    public static List<String> filterRooms(String[][] instructions, String[] treasureRoom) {
        // Map to hold the count of incoming instructions for each room

        List<String> treasureRooms = Arrays.asList(treasureRoom);
        Map<String, Integer> incomingCount = new HashMap<>();
        Map<String, String> immediateDestination = new HashMap<>();

        for (String[] instruction : instructions) {
            String source = instruction[0];
            String destination = instruction[1];

            immediateDestination.put(source, destination);
            if (!source.equals(destination))
                incomingCount.put(destination, incomingCount.getOrDefault(destination, 0) + 1);
        }

        List<String> validRooms = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : incomingCount.entrySet()) {
            String room = entry.getKey();
            int count = entry.getValue();

            if (count >= 2 && treasureRooms.contains(immediateDestination.get(room))) {
                validRooms.add(room);
            }
        }
// Alt
//        for (String room : incomingCount.keySet()) {
//            if (incomingCount.containsKey(room)) {
//                if (incomingCount.get(room) >= 2) {
//                    if (treasureRooms.contains(immediateDestination.get(room))) {
//                        validRooms.add(room);
//                    }
//                }
//            }
//        }

        return validRooms;
    }

    public static void main(String[] args) {
        String[][] instructions1 = {{"jasmin", "tulip"},
                {"lily", "tulip"},
                {"tulip", "tulip"},
                {"rose", "rose"},
                {"violet", "rose"},
                {"daisy", "violet"},
                {"iris", "violet"}};

        String[][] instruction2 = {
                {"jasmin", "tulip"},
                {"lily", "tulip"},
                {"tulip", "violet"},
                {"violet", "violet"}
        };

        String[] treasureRooms1 = {"lily", "tulip", "violet", "rose"};
        String[] treasureRoom2 = {"lily", "jasmine", "violet"};
        String[] treasureRoom3 = {"violet"};

        System.out.println(filterRooms(instructions1, treasureRooms1)); // ["tulip", "voilet"]
        System.out.println(filterRooms(instructions1, treasureRoom2)); // []
        System.out.println(filterRooms(instruction2, treasureRoom3)); // ["tulip"]
    }
}
