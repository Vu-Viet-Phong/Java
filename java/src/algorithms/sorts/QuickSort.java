package algorithms.sorts;

public class QuickSort {
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = arr[right];
            int partition = partition(arr, left, right);
            quickSort(arr, left, partition - 1);  // sort left side
            quickSort(arr, partition + 1, right); // sort right side
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int indexPivot = right;
        int pivot = arr[indexPivot];

        left--;
        while (left < right) {
            while (arr[++left] < pivot);
            while (right > 0 && arr[--right] > pivot);
            
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, left, indexPivot);
        return left;
    }

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

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: ");
        display(arr);
    }
}
