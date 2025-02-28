package coreJava.inheritance;

public class Child extends Parent {

    public Child() {
        Child.super.display();
    }

    public static void main(String[] args) {
        Child child = new Child();
//        child.display();
    }
}
