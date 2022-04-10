package iu.oop.labs.lab07;

public class Gojek extends TransportService {
    public Gojek(int distance, String serviceType) {
        super(distance, serviceType);
    }   

    public double getPrice() {
        return getDistance() <= 5 ? getDistance() * 0.7 : (getDistance() - 5) * 1.2 + 3.5; 
    }
}
