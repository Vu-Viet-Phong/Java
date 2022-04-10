package iu.oop.labs.lab07;

public class Visa extends PaymentService {
    public Visa(int value, String paymentService) {
        super(value, paymentService);
    }
    
    public double getFee(double price) {
        return price / 100;
    }
}
