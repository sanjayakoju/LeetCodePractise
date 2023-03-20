package interfaces.functionaInterface;

public class MainDemo {

    public static void main(String[] args) {
        MyFunctionalInterface myFunctionalInterface = (String st) -> {
            System.out.println(st);
            return st;
        };

        myFunctionalInterface.sayHello("Hello");
    }
}
