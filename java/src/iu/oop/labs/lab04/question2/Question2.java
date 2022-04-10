package iu.oop.labs.lab04.question2;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Question2 extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();     // total width
        int height = getHeight();   // total height

        g.drawLine(0, 0, width, height);
        g.drawLine(0, height, width, 0);
        g.drawLine(width / 2, 0, width / 2, height);
        g.drawLine(0, height / 2, width, height / 2);
    }
}
