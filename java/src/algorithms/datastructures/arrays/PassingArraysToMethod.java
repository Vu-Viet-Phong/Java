package algorithms.datastructures.arrays;

public class PassingArraysToMethod {
    public static void sum(int[] arr) {
        int sum = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        System.out.println("Sum of array values: " + sum);
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 1, 6, 3};
        
        sum(arr);
    }
}
