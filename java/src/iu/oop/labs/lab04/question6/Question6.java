package iu.oop.labs.lab04.question6;

import java.awt.*;
import javax.swing.*;

public class Question6 extends JPanel {
    int num1, num2, num3, num4, num5;

    public Question6() {
        num1 = Integer.parseInt(JOptionPane.showInputDialog("Enter the length of bar 1"));
        num2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the length of bar 2"));
        num3 = Integer.parseInt(JOptionPane.showInputDialog("Enter the length of bar 3"));
        num4 = Integer.parseInt(JOptionPane.showInputDialog("Enter the length of bar 4"));
        num5 = Integer.parseInt(JOptionPane.showInputDialog("Enter the length of bar 5"));
    }

    @Override
    public void paintComponent(Graphics g) {
        int width = getWidth()
                / (Math.max(num1, Math.max(num2, Math.max(num3, Math.max(num4, num5)))) + 1);
        int height = getHeight() / 11;
        g.setColor(Color.black);
        g.fillRect(0, height * 1, num1 * width, height);
        g.setColor(Color.blue);
        g.fillRect(0, height * 3, num2 * width, height);
        g.setColor(Color.red);
        g.fillRect(0, height * 5, num3 * width, height);
        g.setColor(Color.pink);
        g.fillRect(0, height * 7, num4 * width, height);
        g.setColor(Color.green);
        g.fillRect(0, height * 9, num5 * width, height);
    }
}
