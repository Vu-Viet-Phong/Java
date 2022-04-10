package iu.oop.labs.lab04.question5; 

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Question5A extends JPanel {
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.MAGENTA);
        int width = getWidth();
        int height = getHeight();
        
        int x = width / 2;
        int y = height / 2;
        int step = 50;
        while(x > 0 && y > 0){
            g.drawLine(x, y, x, y + step);
            y += step;
            g.drawLine(x, y, x - step, y);
            x -= step;
            step += 50;
            g.drawLine(x, y, x, y - step);
            y -= step; 
            g.drawLine(x, y, x + step, y);
            x += step;
            step += 50; 
        }
    }
}

