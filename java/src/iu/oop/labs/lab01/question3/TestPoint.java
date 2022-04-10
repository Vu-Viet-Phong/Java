package iu.oop.labs.lab01.question3;

import java.util.Scanner; 

public class TestPoint {
    public static void main(String[] args) {
        double x, y;
        Scanner sc = new Scanner(System.in);

        System.out.print("Point A: ");
        x = sc.nextDouble();
        y = sc.nextDouble();
        Point A = new Point(x, y);

        System.out.print("Point B: ");
        x = sc.nextDouble();
        y = sc.nextDouble();
        Point B = new Point(x, y);

        System.out.printf("Distance = %.3f\n", A.distance(B));
    }
}
