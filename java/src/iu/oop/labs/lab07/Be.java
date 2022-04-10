package iu.oop.labs.lab07;

public class Be extends TransportService {
    public Be(int distance, String serviceType) {
        super(distance, serviceType);
    }

    public double getPrice() {
        return getDistance() <= 3 ? getDistance() * 0.5 : (getDistance() - 3) * 1.5 + 1.5; 
    }
}
