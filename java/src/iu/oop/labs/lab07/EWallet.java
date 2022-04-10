package iu.oop.labs.lab07;

public class EWallet extends PaymentService {
    public EWallet(int value, String paymentService) {
        super(value, paymentService);
    }

    public double getFee(double price) {
        return (price * 0.8) / 100;
    }
}
