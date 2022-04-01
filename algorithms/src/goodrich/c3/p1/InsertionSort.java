package goodrich.c3.p1;

public class InsertionSort {
    /* Insertion-sort of an array of characters into nondecreasing order */
    public static void insertionSort(char[] arr) {
        for (int i = 1; i < arr.length; i++) {
            char temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;  
        }
    }
}