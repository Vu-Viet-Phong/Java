package iu.oop.labs.lab04.question4;  

import java.awt.Graphics;
import javax.swing.JPanel;

public class Question4B extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        for (int i = 0, j = 0; i < width || j < height; i += width / 15, j += height / 15) {
            g.drawLine(0, j, i, height);
            g.drawLine(i, 0, width, j);
            g.drawLine(width - i, 0, 0, j);
            g.drawLine(width, j, width - i, height);
        }
    }
}
