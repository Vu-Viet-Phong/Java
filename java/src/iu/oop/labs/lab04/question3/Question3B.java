package iu.oop.labs.lab04.question3;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Question3B extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(width, height);

        for (int i = 0; i < max; i += 10) {
            g.drawLine(0, 0, i, max - i);
            g.drawLine(width, 0, i, i);
            g.drawLine(0, height, i, i);
            g.drawLine(width, height, i, max - i);
        }
    }
}
