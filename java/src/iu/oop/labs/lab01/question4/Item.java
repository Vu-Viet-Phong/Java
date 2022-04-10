package iu.oop.labs.lab01.question4;

public class Item {
    private String itemID;
    private String itemName;
    private double itemPrice;
    
    public Item() {
        itemID = null;
        itemName = null;
        itemPrice = 0;
    }
    
    public Item(String itemID, String itemName, double itemPrice) {
        this.itemPrice = itemPrice;
        this.itemID = itemID;
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "[itemID=" + itemID + ", itemName=" + itemName + ", itemPrice=" + itemPrice + "]";
    }

}
