package coreJava.streamApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamDemo {

    static List<Employee> loadData() {
        List<Employee> employees = new ArrayList<>();
        Address address1 = new Address();
        address1.setCity("Seattle");
        address1.setState("WA");
        address1.setZipCode("98118");

        Employee e1 = new Employee();
        e1.setName("Sanjaya");
        e1.setAddress(address1);
        e1.setMobile("6418192555");
        e1.setDepartment("IT");

        Employee e2 = new Employee();
        e2.setName("Omkar");
        e2.setAddress(address1);
        e2.setMobile("6418192444");
        e2.setDepartment("IT");

        employees.add(e1);
        employees.add(e2);

        Collections.unmodifiableList(employees);
        return employees;
    }

    public static void main(String[] args) {
        List<Employee> employees = StreamDemo.loadData();

        List<Employee> employeeList = employees.stream()
                .filter(employee -> employee.getName().startsWith("S"))
                .map(employee -> {
                    Employee employee1 = new Employee();
                    employee1.setName(employee.getName().toUpperCase());
                    employee1.setDepartment(employee.getDepartment().toUpperCase());
                    return employee1;
                })
                .toList();

        System.out.println("Employee Name Starts with : \n"+employeeList+"\n");

        Map<String, Employee> employeeMap = employees.stream()
                .collect(Collectors.toMap(Employee::getName, employee -> employee));
        System.out.println("Map Employee with key : \n"+employeeMap+"\n");

        Map<String,List<Employee>> listMap = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getAddress().getCity()));
        System.out.println("Group by city: \n"+listMap+"\n");
    }
}
