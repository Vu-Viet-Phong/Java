package iu.oop.labs.lab03.question1;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyLine extends MyShape {
    public static int x1;
    public static int x2;
    public static int y1; 
    public static int y2;

    public MyLine(int X1, int Y1, int X2, int Y2) {
        x1 = X1;
        x2 = X2;
        y1 = Y1;
        y2 = Y2;
    }

    public static int getX1() {
        return x1;
    }

    public static int getX2() {
        return x2;
    }

    public static int getY1() {
        return y1;
    }

    public static int getY2() {
        return y2;
    }

    @Override
    public void Draw() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Draw Line");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(300, 300);

        final JTextField text = new JTextField();
        frame.add(text,BorderLayout.SOUTH);

        frame.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent me) {}
            public void mouseReleased(MouseEvent me) {}
            public void mouseEntered(MouseEvent me) {}
            public void mouseExited(MouseEvent me) {}

            public void mouseClicked(MouseEvent me) {
                int x = me.getX();
                int y = me.getY();
                text.setText("X:" + x + " Y:" + y);
            }
        });

        frame.getContentPane().add(new Draw(0));
        frame.setVisible(true);
    }
}
