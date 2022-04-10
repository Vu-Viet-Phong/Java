package iu.oop.labs.lab01.question4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String checkUserInput;

        while (true) {
            System.out.print("Add Order? [Y/N]: ");
            checkUserInput = input.next(); // input order ID

            if (checkUserInput.equalsIgnoreCase("N")) {
                break;
            } else if (checkUserInput.equalsIgnoreCase("Y")) {
                System.out.print("Order ID: ");
                String orderID = input.next();
                Order order = new Order(orderID);

                while (true) {
                    System.out.print("Add Item? [Y/N]: "); 
                    checkUserInput = input.next(); // input item ID
                    
                    if (checkUserInput.equalsIgnoreCase("N")) {
                        break;
                    } else if (checkUserInput.equalsIgnoreCase("Y")) {
                        System.out.print("Input Item ID: ");
                        String itemID = input.next();
                        System.out.print("Input Item Name: ");
                        String itemName = input.next();
                        System.out.print("Input Item Price: ");
                        double itemPrice = input.nextDouble();

                        Item item = new Item(itemID, itemName, itemPrice);
                        order.addItem(item); // add item in list of item
                    } else {
                        continue;
                    }
                }
                System.out.println("Average Cost: " + order.calculateAverageCost());
                order.printItem(); // print list of item
            } else {
                continue;
            }
        }
    }
}
