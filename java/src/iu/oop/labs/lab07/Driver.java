package iu.oop.labs.lab07;

import java.util.ArrayList;
import java.util.Random;

public class Driver {
    public enum Status {
        FREE, PROCESSING
    }
    private String name;
    private int distance;
    private Status status;
    private String transportService;
    private ArrayList<PaymentService> listPaymentServices = new ArrayList<>();
    private Customer customer;
    ArrayList<TransportService> listOfServices;
    ArrayList<Driver> listOfDrivers;

    public Driver () {}

    public Driver(String name, int distance, Driver.Status status, String transportService,
        ArrayList<PaymentService> listPaymentServices, Customer customer) {
        this.name = name;
        this.distance = distance;
        this.status = status;
        this.transportService = transportService;
        this.listPaymentServices = listPaymentServices;
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getTransportService() {
        return transportService;
    }

    public void setTransportService(String transportService) {
        this.transportService = transportService;
    }

    public ArrayList<PaymentService> getListPaymentServices() {
        return listPaymentServices;
    }

    public void setListPaymentServices(ArrayList<PaymentService> listPaymentServices) {
        this.listPaymentServices = listPaymentServices;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int completionTime(int distance) {
        return distance * 2;
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

            int rdDistance = rd.nextInt(10) + 1;
            listOfServices.add(new TransportService(rdDistance, serviceType));
        }

        int paymentMethods = rd.nextInt(3) + 1;

        // Initialize a list of payment methods
        for (int i = 0; i < paymentMethods; i++) {
            int m = rd.nextInt(3) + 1;
            int price = rd.nextInt(10) + 10;
            
            String paymentType;
            if (m == 1) {
                paymentType = "Visa";
            } else if (m == 2) {
                paymentType = "E-Wallet";
            } else {
                paymentType = "E-Wallet";
            }

            listPaymentServices.add(new PaymentService(price, paymentType));
        }

        // Initialize the list of drivers
        listOfDrivers = new ArrayList<>();
        for (int i = 0; i < numberOfServices; i++) {
            int numberOfName = i + 1;
            int service = rd.nextInt(listOfServices.size()) + 1;

            listOfDrivers.add(new Driver("D00" + numberOfName, listOfServices.get(i).getDistance(),
                Driver.Status.FREE, listOfServices.get(service).getServiceType(), listPaymentServices, customer));
        }
    }

    public void displayTitle() {
        System.out.println();
        for (int i = 0; i < 107; i++) {
            System.out.print("-");
        }

        System.out.println(String.format("\n| %-10s | %-11s | %-17s | %-56s |", "Driver", "Service", "Status", "Balance"));
        for (int i = 0; i < 107; i++) {
            System.out.print("-");
        }
    }

    public void displayDriver() {
        for (int i = 0; i < listOfServices.size(); i++) {
            System.out.print(String.format("\n| %-10s | %-31s ", 
                listOfDrivers.get(i).getName(), listOfDrivers.get(i).getStatus()));
        }

        int total = 0;

        for (int i = 0; i < listOfServices.size(); i++) {
            total += listPaymentServices.get(i).getValue();    
        }

        System.out.print(String.format(" %-6d", total));
        for (int i = 0; i < listPaymentServices.size(); i++) {
            System.out.print(String.format("%s %d", 
                listPaymentServices.get(i).getPaymentType(), listPaymentServices.get(i).getValue()));
        }
    }
}
