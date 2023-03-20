package designPatterns.structural.adapter;

public class MoveableAdpaterImpl implements MoveableAdapter {

    private Moveable luxuryCars;

    public MoveableAdpaterImpl(Moveable bmw) {
        this.luxuryCars = bmw;
    }

    @Override
    public double getSpeed() {
        return convertMphIntoKmph(luxuryCars.getSpeed());
    }

    private double convertMphIntoKmph(double speed) {
        return speed * 1.60934;
    }
}
