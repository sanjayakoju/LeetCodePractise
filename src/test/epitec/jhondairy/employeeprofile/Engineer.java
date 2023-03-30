package test.epitec.jhondairy.employeeprofile;

public class Engineer extends Employee {

    private int salary;
    private String grade;

    public Engineer(int salary, String grade) {
        this.salary = salary;
        this.grade = grade;
    }

    @Override
    void setSalary(int salary) {
        this.salary = salary;    }

    @Override
    int getSalary() {
        return salary;
    }

    @Override
    void setGrade(String grade) {
        this.setGrade(grade);
    }

    @Override
    String getGrade() {
        return grade;
    }
}
