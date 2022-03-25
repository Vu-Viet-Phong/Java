package sorts;

/**
 * Merge sort (also commonly spelled as mergesort) is an efficient, 
 * general-purpose, and comparison-based sorting algorithm. Most 
 * implementations produce a stable sort, which means that the order 
 * of equal elements is the same in the input and output. Merge sort 
 * is a divide and conquer algorithm that was invented by John von 
 * Neumann in 1945.
 * 
 * @link https://en.wikipedia.org/wiki/Merge_sort
 */
public class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public static void mergeSort(int[] arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }

        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        // Initial index of merged subarray array
        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using mergeSort()
    static void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
            // Merge the sorted halves
            mergeSort(arr, l, m, r);
        }
    }

    // Prints the array
    static void printArr(int arr[]) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        int arr[] = {64, 34, 25, 12, 22, 11, 90};

        sort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: ");
        printArr(arr);
    }
}
