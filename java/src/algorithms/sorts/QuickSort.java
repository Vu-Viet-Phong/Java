package algorithms.sorts;

public class QuickSort {
    public static void quickSort(int[] arr, int left, int right) {
        if (right - left > 0) { // size of array <= 1;
            return;
        } else { // size of array is 2 or larger
            int partition = partition(arr, left, right);
            quickSort(arr, left, partition - 1);  // sort left side
            quickSort(arr, partition + 1, right); // sort right side
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int l = left - 1;
        int r = right;
        int pivot = arr[right];

        while (true) {
            while (arr[++l] < pivot); // nop
            while (r > 0 && arr[--r] > pivot); // nops

            if (l >= r) {
                break;
            } else {
                swap(arr, l, r);
            }
        }
        swap(arr, l, right);
        return l;
    } // end partition()

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
