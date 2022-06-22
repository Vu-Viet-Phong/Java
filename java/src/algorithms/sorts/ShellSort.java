package algorithms.sorts;

/**
 * Shellsort is an in-place comparison sort. It can be seen as 
 * either a generalization of sorting by exchange (bubble sort) 
 * or sorting by insertion (insertion sort).[3] The method starts 
 * by sorting pairs of elements far apart from each other, then 
 * progressively reducing the gap between elements to be compared. 
 * By starting with far apart elements, it can move some 
 * out-of-place elements into position faster than a simple 
 * nearest neighbor exchange.
 * 
 * @link https://en.wikipedia.org/wiki/Shellsort
 */
public class ShellSort {
    /** Shell sort algorithm implements */
    public static void shellSort(int[] arr, int length) {
        int gap = 1;

        /* Calculate gap for optimization purpose */
        while (gap < length / 3) {
            gap = gap * 3 + 1; // (1, 4, 13, 40, 121, ...)
        }

        while (gap > 0) { // decreasing gap, until gap = 1
            for (int i = gap; i < length; i++) {
                int temp = arr[i];
                int j;
                
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
            gap = (gap - 1) / 3;
        }
    }

    /** Prints the array */
    public static void display(int[] arr) {
        for (int idx: arr) {
            System.out.print(idx + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        shellSort(arr, arr.length);
        System.out.println("Sorted array: ");
        display(arr);
    }
}
