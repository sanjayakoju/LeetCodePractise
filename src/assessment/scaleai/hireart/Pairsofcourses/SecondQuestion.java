package assessment.scaleai.hireart.Pairsofcourses;

import java.util.*;

public class SecondQuestion {

    public static Map<String, List<String>> findPairs(String[][] enrollments) {
        Map<String, Set<String>> studentCourses = new HashMap<>();
        Map<String, List<String>> sharedCourses = new HashMap<>();

        // Populate studentCourses map
        for (String[] enrollment : enrollments) {
            String student = enrollment[0];
            String course = enrollment[1];

            if (!studentCourses.containsKey(student)) {
                studentCourses.put(student, new HashSet<>());
            }
            studentCourses.get(student).add(course);
        }
       // System.out.println(studentCourses);
        // Find shared courses for each pair of students
        List<String> students = new ArrayList<>(studentCourses.keySet());
        for (int i = 0; i < students.size(); i++) {
            String student1 = students.get(i);
            Set<String> courses1 = studentCourses.get(student1);

            for (int j = i + 1; j < students.size(); j++) {
                String student2 = students.get(j);
                Set<String> courses2 = studentCourses.get(student2);

                String pairKey = student1 + "," + student2;
                List<String> shared = new ArrayList<>(courses1);
                shared.retainAll(courses2);

                sharedCourses.put(pairKey, shared);
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
                {"58", "Software Design"}};

        String[][] enrollments2 = {
                {"0", "Advanced Mechanics"},
                {"0", "Art History"},
                {"1", "Course 1"},
                {"1", "Course 2"},
                {"2", "Computer Architecture"},
                {"3", "Course 1"},
                {"3", "Course 2"},
                {"4", "Algorithms"}
        };



        Map<String, List<String>> result = findPairs(enrollments1);
        Map<String, List<String>> result2 = findPairs(enrollments2);

        // Print the result

        printResult(result);
        printResult(result2);
    }


    public static void printResult(Map<String, List<String>> result) {
        for (Map.Entry<String, List<String>> entry : result.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
