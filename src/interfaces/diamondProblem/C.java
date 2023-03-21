package interfaces.diamondProblem;

/**
 *
 * Diamond Problem
 * This create ambiguity to the compiler and it will throw an error
 **/

public class C implements A, B{

    public static void main(String[] args) {
        C c = new C();
        c.m1();
    }

    @Override
    public void m1() {
        // Custom Implementation or we call by Interface name.super.function Name
        A.super.m1();
    }
}
