package iu.oop.labs.lab03.question1;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyRectangle extends MyBoundedShape {
    public static int width; 
    public static int height;

    public MyRectangle(int w, int h) {
        width = w;
        height = h;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    @Override
    public void getArea(double x, double y) {
        int area = width * height;
        System.out.println("Area of the Rectangle is: " + area + "\n");
    }

    @Override
    public void Draw() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Draw Rectangle");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(300, 300);

        final JTextField text = new JTextField();
        ;
        frame.add(text, BorderLayout.SOUTH);

        frame.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent me) {
            }

            public void mouseReleased(MouseEvent me) {
            }

            public void mouseEntered(MouseEvent me) {
            }

            public void mouseExited(MouseEvent me) {
            }

            public void mouseClicked(MouseEvent me) {
                int x = me.getX();
                int y = me.getY();
                text.setText("X:" + x + " Y:" + y);
            }
        });

        frame.getContentPane().add(new Draw(2));
        frame.setVisible(true);
    }

}
