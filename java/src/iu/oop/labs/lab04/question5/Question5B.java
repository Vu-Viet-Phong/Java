package iu.oop.labs.lab04.question5; 

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Question5B extends JPanel {
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.MAGENTA);
        int step = 50;
        int width = getWidth();
        int height = getHeight();
        
        int x = width / 2;
        int y = height / 2;
        for (int i = 1; i <= width; i++) {
            g.drawArc(x, y, step, step, 0, 180); 
            step += 50; 
            x -= 50; 
            g.drawArc(x, y - 25, step, step, 0, -180); 
            step += 50; 
            y -= 50; 
        }
    }    
}

