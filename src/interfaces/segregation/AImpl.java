package interfaces.segregation;

public class AImpl implements IInterfaceA {
    @Override
    public void funcA() {
        System.out.println("Call Func A from AIMpl");
    }

    @Override
    public void funcB() {
        System.out.println("Call Func B from AIMpl");
    }
}
