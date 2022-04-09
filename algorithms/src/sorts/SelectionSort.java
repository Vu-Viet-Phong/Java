// Java program for implementation of Selection Sort
package sorts;

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
class SelectionSort {
    /**
     * Selection sort algorithm implements
     * 
     * @param arr to be sorted
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min_idx = i;
            
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        } 
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        selectionSort(arr);
        System.out.println("Sorted array");
        for (int i : arr) {
            System.out.println(i);
        }
    }
}