package tung.lab02;

public class SortingApp {
    public static void test(Array arr) {
        long startTime, endtime;
		Array arr1 = arr.clone();
        Array arr2 = arr.clone();
        Array arr3 = arr.clone();

        // --- Bubble sort ---
        startTime = TimeUtils.now();
		arr1.bubbleSort();
		endtime = TimeUtils.now();
		System.out.printf("Bubble Sort: %d ms\n", endtime - startTime);

        // --- Selection sort ---
		startTime = TimeUtils.now();
		arr2.selectionSort();
		endtime = TimeUtils.now();
		System.out.printf("Selection Sort: %d ms\n", endtime - startTime);
		
		// --- Insertion sort ---
		startTime = TimeUtils.now();
		arr3.insertionSort();
		endtime = TimeUtils.now();
		System.out.printf("Insertion Sort: %d ms\n\n", endtime - startTime);
    }

    public static void main(String[] args) {
        int[] maxSize = {10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000};
        Array arr;

        for (int i: maxSize) {
            System.out.println("----------------------------------");
            System.out.println("Number of elements in array " + i);
            arr = new Array(i);
            arr.randomInit(i);
            test(arr);
        }

        System.out.println("----------------------------------");
        System.out.println("Inversely sorted");
        Array arr2 = new Array(10000);
        arr2.randomInit(10000);
        arr2.inverse();
        test(arr2);

        System.out.println("----------------------------------");
        System.out.println("Already-sorted order");
        Array arr3 = new Array(10000);
        arr3.randomInit(10000);
        arr3.bubbleSort();
        test(arr3);
    }
}
