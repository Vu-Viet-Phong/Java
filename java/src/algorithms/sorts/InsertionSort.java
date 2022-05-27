package algorithms.sorts;

/**
 * Insertion sort is a simple sorting algorithm that builds the 
 * final sorted array (or list) one item at a time. It is much 
 * less efficient on large lists than more advanced algorithms 
 * such as quicksort, heapsort, or merge sort.
 * 
 * @link https://en.wikipedia.org/wiki/Insertion_sort
 */
public class InsertionSort {
    /**
    * Insertion sort algorithm implements
    * 
    * @param arr to be sorted
    */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    /* Prints the array */
    public static void display(int[] arr) {
        for (int idx: arr) {
            System.out.print(idx + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        insertionSort(arr);
        System.out.println("Sorted array: ");
        display(arr);
    }
}