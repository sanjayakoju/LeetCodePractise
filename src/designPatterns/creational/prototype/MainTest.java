package designPatterns.creational.prototype;

import java.util.List;

/**
 * Prototype Pattern says that cloning of an existing object instead of creating new one and can also be customized
 * as per the requirement.
 * This pattern should be followed, if the cost of creating a new object is expensive and resource intensive.
 */
public class MainTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Employes emp = new Employes();
        emp.loadData();

        Employes empNew = (Employes) emp.clone();
        Employes empNew1 = (Employes) emp.clone();

        List<String> list = empNew.getEmpList();
        list.add("Supriya");

        List<String> list1 = empNew1.getEmpList();
        list1.remove("Sanjaya");

        System.out.println("Emp : "+emp.getEmpList());
        System.out.println("EmpNew : "+list);
        System.out.println("EmpNew1 : "+list1);
    }
}
