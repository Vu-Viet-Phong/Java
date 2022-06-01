package algorithms.others;

public class PartitionIt {
    public static int partitionIt(int[] arr, int left, int right, int pivot) {
        int leftPtr = left - 1;
        int rightPtr = right + 1;
        while (true) {
            while (leftPtr < right && arr[++leftPtr] < pivot);
            while (rightPtr > left && arr[--rightPtr] > pivot);
            if (leftPtr >= rightPtr) break;
            else swap(arr, leftPtr, rightPtr);
        }
        return leftPtr;
    }

    /** Swap two elements in array */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int pivot = 99;
        System.out.println("Pivot is " + pivot);
        
        int[] arr = {64, 34, 25, 99, 12, 22, 11, 90};
        int size = arr.length;

        int partDex = partitionIt(arr, 0, size - 1, pivot);
        System.out.println("Partition is at index " + partDex);
    }
}
