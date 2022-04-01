package tung.lab01;

public class SimpleApplication {
	private long[] a; 
	private int nElems;

	public SimpleApplication(int max) {
		a = new long[max];
		nElems = 0;
	}

	public void insert(long value) {
		a[nElems] = value; 
		nElems++;
	}

	public void insertSort(long value) {
		int i;

		for (i = 0; i < nElems; i++) {
			if (a[i] > value) {
				break;
			}
		}
		
		for (int j = nElems; j > i; j--) {
			a[j] = a[j - 1];
		}

		a[i] = value; 
		nElems++;
	} 

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(a[i] + " ");
		}			

		System.out.println("");
	}
	
	public long convertToLongNum() {
		long num = 0;
		
		for (int i = 0; i < nElems; i++) {
			num += a[i] * Math.pow(10, nElems - i - 1);
		}
		
		return num;
	}

	public double getMedian() {
		double median;

		if (nElems % 2 == 0) {
		    median = (double) (a[nElems / 2] + a[nElems / 2 - 1]) / 2;
		} else {
		    median = (double) a[nElems / 2];
		}
		
		return median;
	}

	/**
	 * A method that accepts an integer array and a number of elements as parameters. 
	 * @param arr
	 * @return the minimum 'gap' between adjacent values in the array
	 */
	public static int minGap(int[] arr) {
		if (arr.length < 2) {
			return 0;
		}
		
		int minGap = arr[1] - arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - arr[i - 1] < minGap) {
				minGap = arr[i] - arr[i - 1];
			}
		}
		
		return minGap;
	}
	
	public static void main(String[] args) {
		// 3a
		SimpleApplication arr = new SimpleApplication(100);

		arr.insert(2);
		arr.insert(0);
		arr.insert(1);
		arr.insert(8);
		
		System.out.println("Number: " + arr.convertToLongNum());

		// 3b
		SimpleApplication arr2 = new SimpleApplication(100);

		arr2.insertSort(8);
		arr2.insertSort(12);
		arr2.insertSort(5);
		arr2.insertSort(9);
		arr2.insertSort(1);
		arr2.insertSort(3);

		System.out.println("\nArray: ");
		arr2.display();
		System.out.println("Get Median: " + arr2.getMedian());

		// 3c
		int[] array = {1, 3, 6, 7, 12};
			
		System.out.println(minGap(array));
	}
}