package algorithms.sorts;

/**
 * Selection sort is an in-place comparison sorting algorithm. It has an 
 * O(n^2) time complexity, which makes it inefficient on large lists, and 
 * generally performs worse than the similar insertion sort. Selection 
 * sort is noted for its simplicity and has performance advantages over 
 * more complicated algorithms in certain situations, particularly where 
 * auxiliary memory is limited
 * 
 * @link https://en.wikipedia.org/wiki/Selection_sort
 */
public class SelectionSort {
    /* Selection sort algorithm implements */
    public static void selectionSort(int[] arr, int length) {
        for (int i = 0; i < length - 1; i++) {
            int min_idx = i;

            for (int j = i + 1; j < length; j++) {
                if (arr[min_idx] > arr[j]) {
                    min_idx = j;
                }
            }

            if (min_idx != i) {
                swap(arr, min_idx, i);
            }
        }
    }

    /* Swaps two elements */
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /* Prints the array */
    public static void display(int[] arr) {
        for (int idx: arr) {
            System.out.print(idx + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        selectionSort(arr, arr.length);
        System.out.println("Sorted array: ");
        display(arr);
    }
}