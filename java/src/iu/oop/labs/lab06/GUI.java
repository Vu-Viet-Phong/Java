package iu.oop.labs.lab06;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Color;
import java.awt.FlowLayout;

public class GUI extends JFrame {
    public Process process = new Process();

    public GUI() {

        JLabel demand = new JLabel("Choose one of three buttons: ");
        getContentPane().add(demand);

        JButton addButton = new JButton("Add");
        addButton.setBackground(Color.green);
        getContentPane().add(addButton);

        JButton removeButton = new JButton("Remove");
        removeButton.setBackground(Color.red);
        getContentPane().add(removeButton);

        JButton searchButton = new JButton("Search");
        searchButton.setBackground(Color.blue);
        getContentPane().add(searchButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ("Add".equals(e.getActionCommand())) {
                    String nameOfProduct = JOptionPane.showInputDialog("Add a name of product");
                    String numbers = JOptionPane.showInputDialog("Add amount of product");
                    String detail = JOptionPane.showInputDialog("Add the descripstion");

                    int numbersOfProduct = Integer.parseInt(numbers);
                    int index = process.searchProduct(nameOfProduct);
                    if (index == -1) {
                        Product p = new Product(nameOfProduct, numbersOfProduct, detail);
                        process.addProduct(p);
                    } else
                        process.addAmount(index, numbersOfProduct);
                    try {
                        process.saveData();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ("Remove".equals(e.getActionCommand())) {
                    String nameOfRemove =
                            JOptionPane.showInputDialog("What product do you want to remove?");
                    int index = process.searchProduct(nameOfRemove);
                    process.removeProduct(index);
                    JOptionPane.showMessageDialog(null, "The product is deleted!");
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String NameOfProduct =
                        JOptionPane.showInputDialog("What product do you want to find?");
                int index = process.searchProduct(NameOfProduct);
                if (index != -1)
                    JOptionPane.showMessageDialog(null, "Product: " + NameOfProduct + "\nAmount: "
                            + process.getProducts().get(index).getNumbersOfProduct()
                            + "\nDescription: " + process.getProducts().get(index).getDetail());
                else
                    JOptionPane.showMessageDialog(null, "Product name: " + NameOfProduct
                            + "\nAmount" + 0 + "\nDescription: null");

            }
        });

        setLayout(new FlowLayout());
        pack();
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new GUI();
    }
}
