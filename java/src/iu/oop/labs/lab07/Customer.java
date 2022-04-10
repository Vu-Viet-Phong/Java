package iu.oop.labs.lab07;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Customer {
    private enum Status {
        BOOKING, PROCESSING, BANNED
    }
    private String name;
    private int distance;
    private Status status;
    private String transportService;
    private List<PaymentService> listPaymentServices;
    private Driver driver;
    ArrayList<TransportService> listOfServices;
    ArrayList<Customer> listOfCustomers;

    public Customer() {}

    public Customer(String name, int distance, Customer.Status status, String transportService,
        List<PaymentService> listPaymentServices, Driver driver) {
        this.name = name;
        this.distance = distance;
        this.status = status;
        this.transportService = transportService;
        this.listPaymentServices = listPaymentServices;
        this.driver = driver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getStatus() {
        if (this.status == Status.BOOKING) {
            return "BOOKING (" + transportService + ")";
        } else if (this.status == Status.PROCESSING) { 
            return "Being carried by " + driver.getName() + "(" + transportService + ")";
        } else {
            return "I am BANNED..."; 
        }
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTs() {
        return transportService;
    }

    public void setTs(String transportService) {
        this.transportService = transportService;
    }

    public List<PaymentService> getListPaymentServices() {
        return listPaymentServices;
    }

    public void setListPaymentServices(List<PaymentService> listPaymentServices) {
        this.listPaymentServices = listPaymentServices;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    
    public void generator() {
        Random rd = new Random();

        int numberOfServices = rd.nextInt(10) + 1;

        // Initialize the list of services
        listOfServices = new ArrayList<>();
        for (int i = 0; i < numberOfServices; i++) {
            int driverType = rd.nextInt(3) + 1;
            
            String serviceType;
            if (driverType == 1) {
                serviceType = "Grap";
            } else if (driverType == 2) {
                serviceType = "Gojek"; 
            } else {
                serviceType = "Be";
            }

            listOfServices.add(new TransportService(rd.nextInt(10) + 1, serviceType));
        }

        int numberOfCustomers = rd.nextInt(10) + 1;
       
        // Initialize a list of customers
        listOfCustomers = new ArrayList<>(numberOfCustomers);
        for (int i = 0; i < numberOfCustomers; i++) {
            int numberOfName = i + 1;
            int service = rd.nextInt(listOfServices.size()) + 1;

            // Initialize a list of payment methods
            listPaymentServices = new ArrayList<>(3);
            listPaymentServices.add(new PaymentService(rd.nextInt(10) + 10, "Visa"));
            listPaymentServices.add(new PaymentService(rd.nextInt(10) + 10, "E-Wallet"));
            listPaymentServices.add(new PaymentService(rd.nextInt(10) + 10, "E-Wallet"));
            
            listOfCustomers.add(new Customer("C00" + numberOfName, listOfServices.get(i).getDistance(), 
                Status.BOOKING, listOfServices.get(service).getServiceType(), listPaymentServices, driver));
        }
    }

    public void displayTitle() {
        for (int i = 0; i < 47; i++) {
            System.out.print("=");
        }

        System.out.print("System Status");        
        for (int i = 0; i < 47; i++) {
            System.out.print("=");
        }
        
        System.out.println(String.format("\n| %-10s | %-31s | %-56s |", "Customer", "Status", "Balance"));
        for (int i = 0; i < 107; i++) {
            System.out.print("-");
        }
    }

    public void displayCustomer() {
        int total = 0;

        for (int i = 0; i < listPaymentServices.size(); i++) {
            total += listPaymentServices.get(i).getValue();    
        }

        String s = total + " (Visa: " + listPaymentServices.get(1).getValue() + 
                        ",    E-Wallet: " + listPaymentServices.get(2).getValue() +
                        ",    IBanking: " + listPaymentServices.get(3).getValue() + " )";

        for (int i = 0; i < listOfCustomers.size(); i++) {
            System.out.print(String.format("\n| %-10s | %-31s |", 
                listOfCustomers.get(i).getName(), listOfCustomers.get(i).getStatus()));
            System.out.print(" " + s + "|" + String.format("%10", " "));
        }
    }
}
    