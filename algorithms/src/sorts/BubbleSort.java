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
public class BubbleSort {
    /**
    * Bubble sort algorithm implements
    * 
    * @param arr to be sorted
    */
    public static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            boolean swapped = false;
            System.out.println("i " + i);
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    // Prints the array
    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        //int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        bubbleSort(arr);
        System.out.println("Sorted array: ");
        printArr(arr);
    }
}