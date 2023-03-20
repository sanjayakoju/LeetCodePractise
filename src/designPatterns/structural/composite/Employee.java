package designPatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private String department;
    private double salary;
    private List<Employee> employeeList;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        employeeList = new ArrayList<>();
    }

    public void add(Employee employee) {
        employeeList.add(employee);
    }

    public void remove(Employee employee) {
        employeeList.remove(employee);
    }

    public List<Employee> getSubordinates() {
        return employeeList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
