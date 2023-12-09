package assessment.ford.carInheritance;

public abstract class Car {

    boolean isSedan;
    String seats;

    public Car(boolean isSedan, String seats) {
        this.isSedan = isSedan;
        this.seats = seats;
    }

    public abstract String getMilleage();

    public boolean getSedan() {
        return isSedan;
    }

    public String getSeats() {
        return seats;
    }
}
