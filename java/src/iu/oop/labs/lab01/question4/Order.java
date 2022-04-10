package iu.oop.labs.lab01.question4;

import java.util.ArrayList;

public class Order {
    private String orderID;
    private ArrayList<Item> listOfItem = new ArrayList<Item>();
    
    public Order(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public ArrayList<Item> getListOfItem() {
        return listOfItem;
    }

    public void getListOfItem(ArrayList<Item> listOfItem) {
        this.listOfItem = listOfItem;
    }

    public void addItem(Item item) {
        listOfItem.add(item);
    }

    public double calculateAverageCost() {
        double sum = 0;

        for (Item item: listOfItem) 
            sum += item.getItemPrice();

        return sum / listOfItem.size();
    }

    public void printItem() {
        System.out.println("List of Item: ");
        listOfItem.forEach(item -> System.out.println(item.toString()));
    }
}
