package iu.dsa.tung.labs.lab05;

public class Lab05 {
    public static int puzzle(int base, int limit) { 
        if (base > limit) {
            return -1;
        } else if (base == limit) {
            return 1;
        } else {
            return base * puzzle(base + 1, limit);
        }
    }

    public static double sum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return (double) 1 / n + sum(n - 1);
        }
    }

    public static int sumInt(int n) {
        if (n == 1) {
            return 1;
        } else {
            return 1 + sumInt(n - 1);
        }
    }

    public int findmin(int[] a, int n) {
        if (n == 1) {
            return a[0];
        } else {
            int min = a[n - 1];
            if (a[n - 1] > a[n - 2]) {
                    
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(puzzle(14, 10));
        System.out.println(puzzle(4, 7));
        System.out.println(puzzle(0, 0));


    }
}
