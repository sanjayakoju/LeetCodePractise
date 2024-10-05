package coreJava;

public class ProgramWithoutMain implements Cloneable{

    private final String name;
    private final String age;

    static  {
        System.out.println("Hello World!");
    }

    public ProgramWithoutMain(String name, String age) {
        this.name = name;
        this.age = age;
    }



    public static void main(String[] args) throws CloneNotSupportedException {
        ProgramWithoutMain ob = new ProgramWithoutMain("Sa","22");
        ProgramWithoutMain ob1 = (ProgramWithoutMain) ob.clone();
    }
}
