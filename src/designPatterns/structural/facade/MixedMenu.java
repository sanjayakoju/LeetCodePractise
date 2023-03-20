package designPatterns.structural.facade;

public class MixedMenu implements Menu {
    @Override
    public void getMenu() {
        System.out.println("Mixed menu!");
    }
}
