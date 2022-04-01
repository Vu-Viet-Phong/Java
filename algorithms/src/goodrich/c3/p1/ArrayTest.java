package goodrich.c3.p1;

import java.util.Arrays;
import java.util.Random;

public class ArrayTest {
    public static void main(String[] args) {
        int[] data = new int[10];
        Random rd = new Random();
        
        rd.setSeed(System.currentTimeMillis()); // use current time as a seed
        // fill the data array with pseudo-random numbers from 0 to 99, inclusive
        for (int i = 0; i < data.length; i++) {
            data[i] = rd.nextInt(100); // the next pseudo-random number
        }
        int[] orig = Arrays.copyOf(data, data.length); // make a copy of the data array
        System.out.println("arrays equal after sort: " + Arrays.equals(data, orig));
        Arrays.sort(data); // sorting the data array (orig is unchanged)
        System.out.println("arrays equal after sort: " + Arrays.equals(data, orig));
        System.out.println("orig = " + Arrays.toString(orig));
        System.out.println("data = " + Arrays.toString(data));
    }
}
