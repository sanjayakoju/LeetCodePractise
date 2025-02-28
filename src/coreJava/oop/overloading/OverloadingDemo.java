package coreJava.oop.overloading;

public class OverloadingDemo {

    transient int a = 10;

    public int sum(int a, int b) {
        return a + b;
    }

    // Not possible
//    public String sum(int a, int b) {
//        return "";
//    }

    public void abc(int a, int b) {
        System.out.println("abc");
    }

    public void abc(String a, String b) {
        System.out.println("String abc");
    }

    static {
        System.out.println("Static block");
    }

    public static void main(String[] args) {
        String st1 = "hello";
        String st2 = "hello";
        String st3 = new String("hello");

        System.out.println(st1 == st2);
        System.out.println(st1 == st3);

        OverloadingDemo ob = new OverloadingDemo();
        ob.abc(null, null); // String abc

    }
}
