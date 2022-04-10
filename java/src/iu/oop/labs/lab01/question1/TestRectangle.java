package iu.oop.labs.lab01.question1;

import java.util.Random;

public class TestRectangle {
    public static void main(String[] args) {
        Random rectangle = new Random();

        for (int i = 1; i <= 5; i++) {
            int w = rectangle.nextInt(10) + 1;
            int h = rectangle.nextInt(10) + 1;
            System.out.println("\nRectangle " + i);
            new Rectangle(w, h).visualize();
        }
    }
}
