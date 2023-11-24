package test.epitec.jhondairy.employeeprofile;

public abstract class Employee {

    abstract void setSalary(int salary);

    abstract int getSalary();

    abstract void setGrade(String grade);

    abstract String getGrade();

    void label() {
        System.out.println("Employee's data:");
    }
}
