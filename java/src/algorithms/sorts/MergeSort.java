package algorithms.sorts;

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
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] arr_L = new int[n1];
        int[] arr_R = new int[n2];

        for (int i = 0; i < n1; i++) {
            arr_L[i] = arr[left + i];
        }

        for (int i = 0; i < n2; i++) {
            arr_R[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (arr_L[i] <= arr_R[j]) {
                arr[k++] = arr_L[i++];
            } else {
                arr[k++] = arr_R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = arr_L[i++];
        }

        while (j < n2) {
            arr[k++] = arr_R[j++];
        }
    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
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
        
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: ");
        display(arr);
    }
}
