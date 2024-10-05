package coreJava.lambda;

public class LambdaDemo {

    public static void main(String[] args) {
        InterfaceA a = () -> {
            System.out.println("Hello World from IA");
        };
        a.sayHello();

        String s = "Hello";
        InterfaceB b = (st) -> {return st;};
        System.out.println(b.sayHello(s));

        InterfaceB bb = ss -> ss; // return is optional
        System.out.println(bb.sayHello(s));
    }
}
