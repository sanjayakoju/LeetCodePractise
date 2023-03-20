package interfaces.segregation;

public class BImpl implements IInterfaceB {
    @Override
    public void funcA() {
        System.out.println("Call Func A from BIMpl");
    }

    @Override
    public void funcB() {
        System.out.println("Call Func B from BIMpl");
    }

    @Override
    public void funcC() {
        System.out.println("Call Func C from BIMpl");
    }

    @Override
    public void funcD() {
        System.out.println("Call Func D from BIMpl");
    }
}
