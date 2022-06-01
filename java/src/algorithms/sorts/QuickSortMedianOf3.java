package algorithms.sorts;

public class QuickSortMedianOf3 {
    /** Quick sort with median-of-three algorithm implements */
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = arr[right];
            int partition = partition(arr, left, right);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int idxPivot = right;
        int pivot = arr[idxPivot];

        left--;
        while (left < right) {
            while (arr[++left] < pivot);
            while (right > 0 && arr[--right] > pivot);
            
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, left, idxPivot);
        return left;
    }

    /** Swaps two elements */
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /** Prints the array */
    public static void display(int[] arr) {
        for (int idx: arr) {
            System.out.print(idx + " ");
        }
    }
}
