package test.epitec.jhondairy.employeeprofile;

class Manager extends Employee {
    private int salary;
    private String grade;

    public Manager(int salary, String grade) {
        this.salary = salary;
        this.grade = grade;
    }

    @Override
    void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    int getSalary() {
        return salary;
    }

    @Override
    void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    String getGrade() {
        return grade;
    }
}
