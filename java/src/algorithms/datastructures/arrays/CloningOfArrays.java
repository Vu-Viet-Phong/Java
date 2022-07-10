package algorithms.datastructures.arrays;

/* Java program to demonstrate cloning of one-dimensional arrays */
public class CloningOfArrays {
    public static void main(String[] args) {
        int[] intArr = {1, 2, 3};
        int[] cloneArr = intArr.clone();
        int n = cloneArr.length;

        System.out.println(intArr == cloneArr);
        for (int i = 0; i < n; i++) {
            System.out.print(cloneArr[i] + " ");
        }
    }
}
