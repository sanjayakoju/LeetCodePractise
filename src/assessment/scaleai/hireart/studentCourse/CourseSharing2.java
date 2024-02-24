package assessment.scaleai.hireart.studentCourse;

import java.util.*;

public class CourseSharing2 {

    public static Map<String, Set<String>> findSharedCourses(String[][] enrollments) {
        Map<String, Set<String>> courseMap = new HashMap<>();

        for (String[] enrollment : enrollments) {
            String studentID = enrollment[0];
            String course = enrollment[1];

            if (!courseMap.containsKey(studentID)) {
                courseMap.put(studentID, new HashSet<>());
            }

            courseMap.get(studentID).add(course);
        }

        Map<String, Set<String>> sharedCourses = new HashMap<>();

        for (Map.Entry<String, Set<String>> entry1 : courseMap.entrySet()) {
            String studentID1 = entry1.getKey();
            Set<String> courses1 = entry1.getValue();

            for (Map.Entry<String, Set<String>> entry2 : courseMap.entrySet()) {
                String studentID2 = entry2.getKey();
                Set<String> courses2 = entry2.getValue();

                if (!studentID1.equals(studentID2)) {
                    Set<String> commonCourses = new HashSet<>(courses1);
                    commonCourses.retainAll(courses2);

                    if (!commonCourses.isEmpty()) {
                        String pairKey = studentID1.compareTo(studentID2) < 0 ? studentID1 + "," + studentID2 : studentID2 + "," + studentID1;
                        sharedCourses.put(pairKey, commonCourses);
                    }
                }
            }
        }

        return sharedCourses;
    }

    public static void main(String[] args) {
        String[][] enrollments1 = {
                {"58", "Linear Algebra"},
                {"94", "Art History"},
                {"94", "Operating Systems"},
                {"17", "Software Design"},
                {"58", "Mechanics"},
                {"58", "Economics"},
                {"17", "Linear Algebra"},
                {"17", "Political Science"},
                {"94", "Economics"},
                {"25", "Economics"},
                {"58", "Software Design"}
        };

        String[][] enrollments2 = {
                {"10", "Advanced Mechanics"},
                {"8", "Art History"},
                {"1", "Course 1"},
                {"1", "Course 2"},
                {"2", "Computer Architecture"},
                {"3", "Course 1"},
                {"3", "Course 2"},
                {"4", "Algorithms"}
        };

        Map<String, Set<String>> result1 = findSharedCourses(enrollments1);
        System.out.println(result1);

        Map<String, Set<String>> result2 = findSharedCourses(enrollments2);
        System.out.println(result2);
    }
}

