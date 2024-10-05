package coreJava.interfaces.segregation;

public class Runner {
    public static void main(String[] args) {
        AImpl aImpl = new AImpl();
        BImpl bImpl = new BImpl();

        aImpl.funcA();
        aImpl.funcB();

        bImpl.funcA();
        bImpl.funcB();
        bImpl.funcC();
        bImpl.funcD();
    }
}
