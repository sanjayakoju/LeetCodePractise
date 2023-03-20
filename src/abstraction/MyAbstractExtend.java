package abstraction;

/**
 * Why does an abstract class give only partial abstraction?
 *
 * This is because the abstract class can have both abstract as well as non abstract methods and non abstract
 * methods make it partial abstraction.
 */
public class MyAbstractExtend extends MyAbstract {
    @Override
    void funcA() {
        System.out.println("From FUnc A");
    }

    @Override
    void funcC() {
        System.out.println("From Func C");
    }

    public static void main(String[] args) {
        MyAbstractExtend ob = new MyAbstractExtend();
        ob.funcA();
        ob.funcB();
        ob.funcC();
    }
}
