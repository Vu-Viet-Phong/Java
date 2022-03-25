package searches;

import java.util.Arrays;

/**
 * @link https://en.wikipedia.org/wiki/Exponential_search
 */
class ExponentialSearch {
    static int exponentialSearch(int[] arr, int key) {
        // If x is present first location itself
        if (arr[0] == key) {
            return 0;
        }

        // Find range for binary search by repeated doubling
        int i = 1;
        while (i < arr.length && arr[i] <= key) {
            i *= 2;
        }

        System.out.println(i);
        // Call binary search for the found range.
        return Arrays.binarySearch(arr, i / 2, Math.min(i, arr.length - 1), key);
    }

    public static void main(String[] args) {
        int n = 25;
        int[] arr = {11, 12, 22, 25, 34, 64, 70, 88, 90, 100};
        
        int index = exponentialSearch(arr, n);
        System.out.println("\nNumber " + n + " is at index " + index);
    }
}
