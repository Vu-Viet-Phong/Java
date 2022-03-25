package maths;

import java.util.Arrays;

// Java program to find median
public class Median {
    /**
     * Find the median of an array of integers
     * 
     * @param arr array of integers
     * @return median of the array
     */
    public static double median(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        return  n % 2 != 0 
                ? arr[n / 2]
                : (arr[(n - 1) / 2] + arr[n / 2]) / 2.0;
    }

    public static void main(String[] args) {
        int arr[] = {4, 1, 3, 2};
        int arr1[] = {1, 3, 3, 6, 7, 8, 9};
        int arr2[] = {1, 2, 3, 4, 5, 6, 8, 9};
        
        System.out.println(median(arr));
        System.out.println(median(arr1));
        System.out.println(median(arr2));
    }
}
