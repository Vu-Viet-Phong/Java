package iu.oop.labs.lab07;

public class PaymentService {
    private double price;
    protected int value;
    private String paymentType;
    private EWallet ewallet;
    private Visa visa;
    private IBaking ibaking;

    public PaymentService(int values, String paymentType) {
        this.value = values;
        this.paymentType = paymentType;
    }

    public String getPaymentType() { return paymentType; }
    public int getValue() { return value; }

    public double getTotalPrice(double p) {
        if (getPaymentType().equalsIgnoreCase("Visa")) {
			price = p + visa.getFee(p);
		} 
        
        if (getPaymentType().equalsIgnoreCase("EWallet")) {
			price = p + ewallet.getFee(p);
		}
        
        if (getPaymentType().equalsIgnoreCase("IBaking")) {
            price = p + ibaking.getFee(p);
        }
		
        return price;
    }
}
