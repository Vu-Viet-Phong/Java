package iu.oop.labs.lab03.question1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            Scanner input = new Scanner(System.in);
            System.out.println("Input shape:\n- Rectangle\n- Oval\n- Line :");
            System.out.println("Enter the name of the Shape type: ");
            String obj = input.nextLine();

            if ("Rectangle".equalsIgnoreCase(obj)) {
                System.out.println("Input two dimensions, width then height:");
                int width = input.nextInt();
                int height = input.nextInt();
                MyBoundedShape rect = new MyRectangle(width, height);
                rect.Draw();
                rect.getArea(width, height);
            } else if ("Oval".equalsIgnoreCase(obj)) {
                System.out.println("Input width and height:");
                int w = input.nextInt();
                int h = input.nextInt();
                MyBoundedShape oval = new MyOval(w, h);
                oval.Draw();
                oval.getArea(w, h);
            } else if ("Line".equalsIgnoreCase(obj)) {
                System.out.println("Input coordinate x1 and y1:");
                int x1 = input.nextInt();
                int y1 = input.nextInt();
                System.out.println("Input coordinate x2 and y2:");
                int x2 = input.nextInt();
                int y2 = input.nextInt();
                MyShape line = new MyLine(x1, y1, x2, y2);
                line.Draw();
            }
        }
    }
}
