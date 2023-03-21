package abstraction;

/**
 * Why does an abstract class give only partial abstraction?
 *
 * This is because the abstract class can have both abstract as well as non abstract methods and non abstract
 * methods make it partial abstraction.
 *
 * Abstract classes have a default constructor and it is called whenever the concrete subclass is instantiated.
 * It contains Abstract methods as well as Non-Abstract methods.
 * The class which extends the Abstract class shouldn’t require the implementation of all the methods, only Abstract
 * methods need to be implemented in the concrete sub-class.
 * Abstract class contains instance variables.
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
