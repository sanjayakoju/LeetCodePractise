package assessment.ford.carInheritance;

public class WagonR extends Car {

    int milege;

    public WagonR(int milege) {
        super(false, String.valueOf(4));
        this.milege = milege;
    }

    @Override
    public String getMilleage() {
        return String.valueOf(milege);
    }
}
