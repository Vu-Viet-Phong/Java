package iu.oop.labs.lab07;

public class IBaking extends PaymentService {
    public IBaking(int value, String paymentService) {
        super(value, paymentService);
    }
    
    public double getFee(double price) {
        return (price * 0.5) / 100;
    }
}
