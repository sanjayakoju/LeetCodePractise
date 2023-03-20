package designPatterns.structural.composite;

/**
 * Composite pattern is used where we need to treat a group of objects in similar way as a single object. Composite
 * pattern composes objects in term of a tree structure to represent part as well as whole hierarchy. This type of
 * design pattern comes under structural pattern as this pattern creates a tree structure of group of objects.
 *
 * This pattern creates a class that contains group of its own objects. This class provides ways to modify its group
 * of same objects.
 *
 * We are demonstrating use of composite pattern via following example in which we will show employees hierarchy of
 * an organization.
 */
public class CompositeDemo {

    public static void main(String[] args) {
        Employee CEO = new Employee("John", "CEO", 12000);
        Employee headSales = new Employee("RObert", "Head Sales", 9000);
        Employee headMarketing = new Employee("Angelina", "Head Marketing", 8000);

        Employee clerk1 = new Employee("Laura","Marketing", 10000);
        Employee clerk2 = new Employee("Bob","Marketing", 10000);

        Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob","Sales", 10000);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        System.out.println(CEO);

        for (Employee headEmp: CEO.getSubordinates()) {
            System.out.println(headEmp);
            for(Employee employee: headEmp.getSubordinates()) {
                System.out.println(employee);
            }
        }
    }
}
