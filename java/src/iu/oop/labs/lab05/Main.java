package iu.oop.labs.lab05;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("ITDSIU", "Ngoc", 2000, 5, 3);
        Employee e2 = new Employee("ITITIU", "Ha", 1500, 7, 4);
        System.out.println("Compare e1 with e2: " + e1.compareTo(e2));
        
        ArrayList e = new ArrayList<>();
        e.add(e1);
        e.add(e2);

        Project Oop = new Project("1", 
                                new Date(2020 - 1900, Calendar.OCTOBER, 10),
                                new Date(2020 - 1900, Calendar.DECEMBER, 15), 
                                e);
        ProjectPrinter oop = new ProjectPrinter(Oop);
        oop.run();

        System.out.println("Employee 1 to 2 is: " + e1.compareTo(e2));
        System.out.println("Budget: " + Oop.estimateBudget());
        System.out.println(e1.toString());
        System.out.println(Oop.toString());
    }
}
