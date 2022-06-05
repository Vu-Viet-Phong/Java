package algorithms.sorts;

import java.util.Arrays;

public class RadixSort {
    static int getMax(int[] arr) {
        int n = arr.length;
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        int i;
        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    static void radixSort(int[] arr) {
        int max = getMax(arr); 

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    /* Prints the array */
    static void display(int[] arr) {
        for (int i: arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        radixSort(arr);
        System.out.println("Sorted array: ");
        display(arr);
    }
}
