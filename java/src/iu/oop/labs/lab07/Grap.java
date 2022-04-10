package iu.oop.labs.lab07;

public class Grap extends TransportService {
    public Grap(int distance, String serviceType) {
        super(distance, serviceType);
    }

    public double getPrice() {
        return getDistance() <= 2 ? getDistance() * 0.5 : (getDistance() - 2) + 1; 
    }
}
