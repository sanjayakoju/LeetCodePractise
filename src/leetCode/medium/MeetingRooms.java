package leetCode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return true;
        }

        // Sort intervals by their start time
        intervals.sort(Comparator.comparingInt(a -> a.start));

        // Check for overlapping intervals
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < intervals.get(i - 1).end) {
                return false;  // There is an overlap
            }
        }

        return true;  // No overlaps, so the person can attend all meetings
    }

    public static void main(String[] args) {
        MeetingRooms solution = new MeetingRooms();

        // Test case 1
        List<Interval> meetings = new ArrayList<>();
        meetings.add(new Interval(1, 3));
        meetings.add(new Interval(2, 4));
        meetings.add(new Interval(5, 6));
        System.out.println(solution.canAttendMeetings(meetings));  // Output: false

        // Test case 2
        meetings = new ArrayList<>();
        meetings.add(new Interval(1, 2));
        meetings.add(new Interval(3, 4));
        meetings.add(new Interval(5, 6));
        System.out.println(solution.canAttendMeetings(meetings));  // Output: true
    }
}
