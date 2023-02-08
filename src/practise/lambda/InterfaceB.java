package practise.lambda;

@FunctionalInterface
public interface InterfaceB {
    public String sayHello(String s);

    default void hello() {
        System.out.println("hello from default");
    }

    static void nice() {
        System.out.println("Nice");
    }
}
