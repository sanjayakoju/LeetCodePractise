package designPatterns.structural.facade;

public class VegMenu implements Menu{
    @Override
    public void getMenu() {
        System.out.println("Veg Menu!");
    }
}
