package iu.oop.labs.lab01.question1;

public class Rectangle {
    private int height;
    private int width;

    public Rectangle(int height, int width) {
        this.width = width;
        this.height = height;

        if (width <= 0) {
            System.out.println("an error message");
            this.width = 1;
        }

        if (height <= 0) {
            System.out.println("an error message");
            this.height = 1;
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void visualize() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    System.out.print("*");
                } else { 
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
