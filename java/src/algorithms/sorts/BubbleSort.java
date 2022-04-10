package algorithms.sorts;

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
        for (int i = 1; i < arr.length; i++) {
            boolean swapped = false;
            
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
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

        bubbleSort(arr);
        System.out.println("Sorted array: ");
        display(arr);
    }
}