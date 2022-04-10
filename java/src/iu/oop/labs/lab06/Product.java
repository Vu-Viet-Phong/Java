package iu.oop.labs.lab06;

public class Product {
    private String nameOfProduct;
    private String detail;
    private int numbersOfProduct;

    public String getNameOfProduct() {
        return this.nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getNumbersOfProduct() {
        return this.numbersOfProduct;
    }

    public void setNumbersOfProduct(int numbersOfProduct) {
        this.numbersOfProduct = numbersOfProduct;
    }

    public Product(String nameOfProduct, int numbersOfProduct, String detail) {
        this.nameOfProduct = nameOfProduct;
        this.numbersOfProduct = numbersOfProduct;
        this.detail = detail;
    }

    public String toString() {
        return getNameOfProduct() + ',' + numbersOfProduct + ',' + detail + '\n';
    }
}
