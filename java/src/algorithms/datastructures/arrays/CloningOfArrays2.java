package algorithms.datastructures.arrays;

public class CloningOfArrays2 {
    public static void main(String[] args) {
        int[][] intArr = {{1, 2, 3}, {4, 5, 6}};
        int[][] cloneArr = intArr.clone();

        System.out.println(intArr == cloneArr);
        System.out.println(intArr[0] == cloneArr[0]);
        System.out.println(intArr[1] == cloneArr[1]);
    }
}
