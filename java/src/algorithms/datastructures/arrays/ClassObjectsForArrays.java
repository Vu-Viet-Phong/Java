package algorithms.datastructures.arrays;

public class ClassObjectsForArrays {
    public static void main(String[] args) {
        int[] intArr = new int[3];
        byte[] byteArr = new byte[3];
        short[] shortArr = new short[3];
        String[] strArr = new String[3];

        System.out.println(intArr.getClass());
        System.out.println(intArr.getClass().getSuperclass());
        System.out.println(byteArr.getClass());
        System.out.println(shortArr.getClass());
        System.out.println(strArr.getClass());
    }
}
