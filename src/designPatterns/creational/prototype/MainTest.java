package designPatterns.creational.prototype;

import java.util.List;

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
