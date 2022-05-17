package algorithms.sorts;

public class Sorts {
    /*Swaps two elements */
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /* Bubble sort algorithm implements */
    public static void bubbleSort(int[] arr) {
        int n = arr.length; 

        for (int i = 1; i < n; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i; j++) {
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

    /* Selection sort algorithm implements */
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[min_idx] > arr[j]) {
                    min_idx = j;
                }
            }
            swap(arr, min_idx, i);
        }
    }

    /* Insertion sort algorithm implements */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }    

    public static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int idx = 0;
        int l = left;
        int m = mid + 1;
        int n = right - left + 1;
        int[] temp = new int[n];
        
        while (l <= mid && m <= right) {
            if (arr[l] < arr[m]) {
                arr[idx++] = arr[l++];
            } else {
                arr[idx++] = arr[m++];
            }
        }

        while (l <= mid) {
            temp[idx++] = arr[l++];
        }        

        while (m <= right) {
            temp[idx++] = arr[m++];
        }

        for (idx = 0; idx < n; idx++) {
            arr[l + idx] = temp[idx];
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
        
        mergeSort(arr);
        System.out.println("Sorted array: ");
        display(arr);
    }
}