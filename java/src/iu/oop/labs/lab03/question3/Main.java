package iu.oop.labs.lab03.question3;

public class Main {
    public static void main(String[] args) {
        Person John = new Student("John", "Pasteur", "IT", 2, 20);
        Person Steve = new Staff("6s", "Pham Ngu Lao", "IU", 32);

        System.out.println(John.toString());
        John.setAddress("HCM");
        System.out.println(John.getAddress());
        System.out.println(John.toString());
        
        System.out.println(Steve.toString());
        System.out.println(Steve.getAddress());
    }
}
