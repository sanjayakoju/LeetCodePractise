package designPatterns.creational.builder;

public class Student {

    private String name; // required
    private int age; // required
    private String phone; // optional
    private String email; // optional

    private Student(StudentBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.phone = builder.phone;
        this.email = builder.email;
    }

    public static class StudentBuilder {
        private final String name; // required
        private final int age; // required
        private String phone; // optional
        private String email; // optional

        public StudentBuilder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public StudentBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public StudentBuilder email(String emai) {
            this.email = emai;
            return this;
        }

        public Student build() {
            Student student = new Student(this);
            return student;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
