package iu.oop.labs.lab01.question2;

public class Triangle {
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
    
    public String verify() {
        if ((a + b) < c || (a + c) < b || (b + c) <a) {
            return "Not triangle";
        } else if(a == b && b == c) {
            return "Equilateral";
        } else if(a == b || b == c || a == c) {
            return "Isosceles";
        }
        return "Scalene";
    }

    /**
    public void verify() {
        if (a * b * c > 0 && a + b > c && a + c > b && b + c > a ) 
            if (a == b || a == c || b == c) 
                if (a == b && a == c) 
                    System.out.println("Equilateral triangle\n");   
                else 
                    System.out.println("Isosceles triangle\n");     
            else if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a )
                if (a == b || a == c || b == c) 
                    System.out.println("Right isosceles triangle\n");
                else 
                    System.out.println("Right triangle\n");
            else 
                System.out.println("Scalene triangle\n"); 
        else 
            System.out.println("Invalid!\n"); 
    }
    */
}
