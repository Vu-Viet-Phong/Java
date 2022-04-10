package iu.oop.labs.lab06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Process {
    ArrayList<Product> products = new ArrayList<Product>();

    Process() {
        try {
            loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void saveData() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("Store.csv"));
        try {
            bw.write("Product Name,Amount,Description\n");
            for (Product p : products) {
                bw.write(p.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bw.flush();
        }
    }

    public void loadData() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Store.csv"));
        String line = "";
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] attributes = line.split(",");
            Product p = new Product(attributes[0], Integer.parseInt(attributes[1]), "");
            if (attributes.length == 3)
                p.setDetail(attributes[2]);
            products.add(p);
        }
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void addAmount(int index, int numbersOfProduct) {
        products.get(index).setNumbersOfProduct(products.get(index).getNumbersOfProduct() + numbersOfProduct);
    }

    public void removeProduct(int index) {
        if (products.get(index).getNumbersOfProduct() > 1)
            products.get(index).setNumbersOfProduct(products.get(index).getNumbersOfProduct() - 1);
        else if (products.get(index).getNumbersOfProduct() == 1)
            products.remove(index);
        try {
            saveData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int searchProduct(String name) {
        for (int i = 0; i < products.size(); ++i) {
            Product product = products.get(i);
            if (name.equals(product.getNameOfProduct()))
                return i;
        }
        return -1;
    }
}
