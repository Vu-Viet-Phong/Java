package iu.oop.labs.lab07;

public class TransportService {
    private int distance;
    private double price;
    private String serviceType;
    private Grap grap;
    private Gojek gojek;
    private Be be;
    
    public TransportService(int distance, String serviceType) {
        this.distance = distance;
        this.serviceType = serviceType;
    }

    public int getDistance() {
        return distance;
    }

    public String getServiceType() {
        return serviceType;
    }

    public double getPrices() {
        if (serviceType.equalsIgnoreCase("Grap")) {
			price = grap.getPrice();
		} 
        
        if (serviceType.equalsIgnoreCase("Gojek")) {
			price = gojek.getPrice();
		}
        
        if (serviceType.equalsIgnoreCase("Be")) {
            price = be.getPrice();
        }
		
        return price;
    }
}
