package algorithms.datastructures.arrays;

public class ReturnArraysFromMethods {
    public static void main(String[] args) {
        int arr[] = demo();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }    
    }

    public static int[] demo() {
        return new int[] {1, 2, 3};
    }
}