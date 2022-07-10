package algorithms.datastructures.arrays;

public class Student {
    private int id;
    private String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        Student[] arr = new Student[5];

        arr[0] = new Student(1, "One");
        arr[1] = new Student(2, "Two");
        arr[2] = new Student(3, "Three");
        arr[3] = new Student(4, "Four");
        arr[4] = new Student(5, "Five");

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.println("Element at " + i + " : " 
                                + arr[i].id + " " 
                                + arr[i].name);
        }
    }
}
