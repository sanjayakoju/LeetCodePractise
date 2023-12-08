package interfaces.abstractclass;

import interfaces.defaultDemo.InterfaceA;

public class MyAbstractImpl extends MyAbstractClass implements InterfaceA {

    // UnImplemented method from Interface
    @Override
    public void sayHi() {

    }

    // From Interface we can modified the default method
    @Override
    public void sayHello() {
        System.out.println("Hello");
    }

    // From Abstract Class
//    @Override
//    public void myMethod() {
//        super.myMethod();
//    }

    public static void main(String[] args) {
        MyAbstractImpl ob = new MyAbstractImpl();
        ob.myMethod();
    }
}
