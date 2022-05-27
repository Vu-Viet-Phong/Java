    package goodrich.c3;

import java.util.Arrays;
import java.util.Random;

public class ArrayTest {
    public static void main(String[] args) {
        int[] data = new int[10];
        Random rd = new Random();

        rd.setSeed(System.currentTimeMillis()); 
        for (int idx = 0; idx < data.length; idx++) {
            data[idx] = rd.nextInt(100);
        }
        int[] orig = Arrays.copyOf(data, data.length);
        System.out.println("array equal before sort: " + Arrays.equals(data, orig));
        Arrays.sort(data);
        System.out.println("Arrays equal after sort: " + Arrays.equals(data, orig));
        System.out.println("orig = " + Arrays.toString(orig));
        System.out.println("data = " + Arrays.toString(data));
    }
}
    