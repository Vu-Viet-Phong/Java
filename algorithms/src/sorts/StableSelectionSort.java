// Java program for modifying Selection Sort so that it becomes stable.
package sorts;

public class StableSelectionSort {
    static void stableSelectionSort(int[] arr) {
        // Iterate through array elements
        for (int i = 0; i < arr.length - 1; i++) {
            // Loop invariant : Elements till a[i - 1] are already sorted.
            // Find minimum element from arr[i] to arr[n - 1].
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }

            // Move minimum element at current i.
            int key = arr[min];
            while (min > i) {
                arr[min] = arr[min - 1];
                min--;
            }

            arr[i] = key;
        }
    }

    // Prints the array
    static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        stableSelectionSort(arr);
        System.out.println("Sorted array");
        printArr(arr);
    }
}
