package designPatterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employes implements Cloneable {

    List<String> empList;

    public Employes() {
        this.empList = new ArrayList<>();
    }

    public Employes(List<String> empList) {
        this.empList = empList;
    }

    public void loadData() {
        empList.add("Sanjaya");
        empList.add("Omkar");
        empList.add("Shrawan");
    }

    public List<String> getEmpList() {
        return empList;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        List<String> temp = new ArrayList<>();
        for (String s: this.getEmpList()) {
            temp.add(s);
        }
        return new Employes(temp);
    }
}
