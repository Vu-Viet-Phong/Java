package sorts;

/**
 * Bubble sort, sometimes referred to as sinking sort, is a simple 
 * sorting algorithm that repeatedly steps through the list, compares 
 * adjacent elements and swaps them if they are in the wrong order. 
 * The pass through the list is repeated until the list is sorted. 
 * The algorithm, which is a comparison sort, is named for the way 
 * smaller or larger elements "bubble" to the top of the list.
 * 
 * @link https://en.wikipedia.org/wiki/Bubble_sort
 */
public class BubbleSortRecursive {
    /**
     * Recursive bubble sort algorithm implements
     * 
     * @param arr to be sorted
     * @param n array length
     */
    public static void recursiveBubbleSort(int[] arr, int n) {
        boolean swapped = false; 

        if (n == 1) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                swapped = true;
            }
        }

        if (swapped) {
            recursiveBubbleSort(arr, n - 1);
        }
    }

    // Prints the array
    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        recursiveBubbleSort(arr, arr.length);
        System.out.println("Sorted array: ");
        printArr(arr);
    }
}
