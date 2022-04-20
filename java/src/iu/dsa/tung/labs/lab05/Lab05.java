package iu.dsa.tung.labs.lab05;

public class Lab05 {
    /**
     * 
     * @param base
     * @param limit
     * @return
     */
    public static int puzzle(int base, int limit) { 
        if (base > limit) {
            return -1;
        } else if (base == limit) {
            return 1;
        } else {
            return base * puzzle(base + 1, limit);
        }
    }

    /**
     * Computes the sum of all numbers from 1 to 1/n
     * 
     * @param n > 1
     * @return the sum  1 + 1/2 + 1/3 +...+ 1/n
     */
    public static double sum(int n) {
        return n == 1 ? 1 : (double) 1 / n + sum(n - 1);
    }

    /**
     * Computes the sum of all numbers from 1 to n
     *  
     * @param n is given parameter
     * @return the sum 1 + 2 + 3 + ... + n
     */
    public static int sumInt(int n) {
        return n == 1 ? 1 : (n + sumInt(n - 1));
    }

    /**
     * Finds the minimum element in an array
     * 
     * @param arr 
     * @param n size array
     * @return the minimum element in array
     */
    public static int findmin(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        } else {
            int min = findmin(arr, n - 1);
            return min > arr[n - 2] ? arr[n - 2] : min;
        }
    }

    /**
     * Compute sum of all elements in array 
     * 
     * @param arr 
     * @param n size array
     * @return the sum of all elements in array
     */
    public static int findSum(int[] arr, int n) {
        return n <= 0 ? 0 : (findSum(arr, n - 1) + arr[n - 1]);  
    }

    /**
     * Get greatest common divisor
     * 
     * @param a the first number
     * @param b the second number
     * @return gcd
     */
    public static int gcd(int a, int b) {
        if (a < 0 || b < 0) {
            throw new ArithmeticException();
        }

        if (a == 0 || b == 0) {
            return 0;
        }

        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        System.out.println(puzzle(14, 10));
        System.out.println(puzzle(4, 7));
        System.out.println(puzzle(0, 0));

        System.out.println(sum(5));
        System.out.println(sumInt(5));
        
        int[] arr = {5, 1, 2, 10, 8, 22, 11};
        System.out.println("Min: " + findmin(arr, arr.length));
        System.out.println("Find sum: " + findSum(arr, arr.length));

        System.out.printf("gcd(%d, %d) = %d", arr[0], arr[3], gcd(arr[0], arr[3]));
    }
}   