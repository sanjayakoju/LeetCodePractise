package practise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// Define the Student class
class Student {
    int studentId;
    String name;
    List<Integer> deptIDs;

    public Student(int studentId, String name, List<Integer> deptIDs) {
        this.studentId = studentId;
        this.name = name;
        this.deptIDs = deptIDs;
    }

    public static void main(String[] args) {
        // Create the lists
        List<Student> list1 = new ArrayList<>();
        List<Department> list2 = new ArrayList<>();

        // Add Students
        list1.add(new Student(1, "abc", List.of(1, 2)));
        list1.add(new Student(2, "cde", List.of(2, 3)));

        // Add Departments
        list2.add(new Department(1, "Department 1"));
        list2.add(new Department(2, "Department 2"));
        list2.add(new Department(3, "Department 3"));

        // Find departments with at least two students
        List<Department> result = findDepartmentsWithAtLeastTwoStudents(list1, list2);

        // Print the result
        result.forEach(dept -> System.out.println("Department ID: " + dept.departmentId + ", Department Name: " + dept.departmentName));
    }

    // Method to find departments with at least two students using Stream API
    public static List<Department> findDepartmentsWithAtLeastTwoStudents(List<Student> students, List<Department> departments) {
        // Count the number of students in each department
        Map<Integer, Long> deptStudentCount = students.stream()
                .flatMap(student -> student.deptIDs.stream())
                .collect(Collectors.groupingBy(deptId -> deptId, Collectors.counting()));

        // Find departments with at least two students
        Set<Integer> deptWithAtLeastTwoStudents = deptStudentCount.entrySet().stream()
                .filter(entry -> entry.getValue() >= 2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        // Filter departments that meet the criteria
        return departments.stream()
                .filter(dept -> deptWithAtLeastTwoStudents.contains(dept.departmentId))
                .collect(Collectors.toList());
    }
}

// Define the Department class
class Department {
    int departmentId;
    String departmentName;

    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }
}
