package coreJava.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
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

    private static void sortMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 3);
        map.put("banana", 2);
        map.put("cherry", 1);

        // Sort by values in ascending order
        Map<String, Integer> result = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())  // Sort by value
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));

        System.out.println(result);

        Map<Integer, String> maps = new HashMap<>();
        maps.put(1, "Apple");
        maps.put(2, "Banana");
        maps.put(3, "Cherry");

        // Stream over map entries and filter
        maps.entrySet()
                .stream()
                .filter(entry -> entry.getKey() % 2 == 0) // filter even keys
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));


        Map<Integer, String> transformedMap = maps.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey() * 2,       // transform key
                        entry -> entry.getValue().toUpperCase() // transform value
                ));

        transformedMap.forEach((k, v) -> System.out.println(k + ": " + v));

        List<String> words = Arrays.asList("apple", "banana", "cherry", "apricot");

        Map<Character, List<String>> groupedByFirstLetter = words.stream()
                .collect(Collectors.groupingBy(word -> word.charAt(0)));

        // Result: {a=[apple, apricot], b=[banana], c=[cherry]}


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

        sortMap();
    }
}
