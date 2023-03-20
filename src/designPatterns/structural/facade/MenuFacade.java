package designPatterns.structural.facade;

public class MenuFacade {
    VegMenu vegMenu;
    NonVegMenu nonVegMenu;
    MixedMenu mixedMenu;

    public MenuFacade() {
        vegMenu = new VegMenu();
        nonVegMenu = new NonVegMenu();
        mixedMenu = new MixedMenu();
    }

    public void getVegMenu() {
        vegMenu.getMenu();
    }

    public void getNonVegMenu() {
        nonVegMenu.getMenu();
    }

    public void getMixedMenu() {
        mixedMenu.getMenu();
    }
}
