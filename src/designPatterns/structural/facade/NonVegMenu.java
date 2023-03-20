package designPatterns.structural.facade;

public class NonVegMenu implements Menu {
    @Override
    public void getMenu() {
        System.out.println("Non Veg Menu!");
    }
}
