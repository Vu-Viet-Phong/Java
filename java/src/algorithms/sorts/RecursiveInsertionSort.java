package algorithms.sorts;

/**
 * Insertion sort is a simple sorting algorithm that builds the 
 * final sorted array (or list) one item at a time. It is much 
 * less efficient on large lists than more advanced algorithms 
 * such as quicksort, heapsort, or merge sort.
 * 
 * @link https://en.wikipedia.org/wiki/Insertion_sort
 */
public class RecursiveInsertionSort {
    /**
     * Recursive insertion sort algorithm implements
     * 
     * @param arr to be sorted
     * @param n array length
     */
    public static void insertionSortRecursive(int[] arr, int n) {
        // Base case
        if (n <= 1) {
            return;
        }

        // Sort first n-1 elements
        insertionSortRecursive(arr, n - 1);
        
        // Insert last element at its correct position in sorted array
        int last = arr[n - 1];
        int j = n - 2;
        
        /* Move elements of arr[0..i-1], that are greater than 
           key, to one position ahead of their current position */
        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;
    }

    // Prints the array
    static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        insertionSortRecursive(arr, arr.length);
        System.out.println("Sorted array: ");
        printArr(arr);
    }
}
