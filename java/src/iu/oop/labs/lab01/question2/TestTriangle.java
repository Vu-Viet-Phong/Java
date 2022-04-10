package iu.oop.labs.lab01.question2;

import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input length:");
        int edge1 = sc.nextInt();
        int edge2 = sc.nextInt();
        int edge3 = sc.nextInt();

        Triangle triangle = new Triangle(edge1, edge2, edge3);
        triangle.verify();
    }    
}
