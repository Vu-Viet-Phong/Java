import java.util.Random;

public class SpecialArray {

    public static long[] generate(long[] arr, int nElems) { 
        Random aRandom = new Random();

        for (int i = 0 ; i < nElems ; i++) {
            arr[i] = aRandom.nextLong() % 100;
        }

        return arr;
    }

    public static long[] update(long[] arr, int nElems, int pos, int value) {
        long[] newarr = new long[nElems + 1];
 
        for (int i = 0; i < nElems + 1; i++) {
            if (i < pos - 1) {
                newarr[i] = arr[i];
            } else if (i == pos - 1) {
                newarr[i] = value;
            } else {
                newarr[i] = arr[i - 1];
            }
        }

        return newarr;
    }

    public static void display(long[] arr, int nElems) {
		for (int i = 0; i < nElems; i++) {
			System.out.print(arr[i] + " ");
		}			

		System.out.println("");
	}

    public static void main(String[] args) {
        int nElems = 20;
        long[] arr = new long[nElems];

        generate(arr, nElems);
        System.out.print("-------------------------------");
        System.out.print("Origin array");
        System.out.println("------------------------------");
        display(arr, nElems);

        System.out.print("-------------------------------");
        System.out.print("Update array");
        System.out.println("------------------------------");
        long[] new_arr = update(arr, nElems, 10, 20);
        display(new_arr, new_arr.length);
    }
}
