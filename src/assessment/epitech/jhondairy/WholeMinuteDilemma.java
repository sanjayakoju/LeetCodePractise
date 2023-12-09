package assessment.epitech.jhondairy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WholeMinuteDilemma {

    public static long playlist(List<Integer> songs) {
        long count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < songs.size(); i++) {
            int rem = songs.get(i) % 60;
            int pair = (60 - rem) % 60;
            count += map.getOrDefault(pair, 0);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
