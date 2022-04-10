package iu.oop.labs.lab04.question1;

import javax.swing.JOptionPane;

public class Question1 {
	public static void main(String[] args) {
        // Prompt user to enter name
        String name = JOptionPane.showInputDialog("What is your name?");
        // Display the message to welcome the user by name
        JOptionPane.showMessageDialog(null, "Welcome, " + name + ", to Java Programming!");
    }
}
