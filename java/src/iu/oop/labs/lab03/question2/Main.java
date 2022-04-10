package iu.oop.labs.lab03.question2;

public class Main {
    public static void main(String[] args) {
        MyTriangle triangle = new MyTriangle(1, 2, 3, 4, 5, 6);
        
        System.out.println(triangle.toString()); 
        System.out.println("The perimeter of the triangle is: " + triangle.getPerimeter());
        System.out.println("The type of triangle is: " + triangle.getType());
    }
}
