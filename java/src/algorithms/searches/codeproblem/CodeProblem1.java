package algorithms.searches.codeproblem;

/**
 * Given a list of n-1 integers and these integers are in the 
 * range of 1 to n. There are no duplicates in the list. One 
 * of the integers is missing in the list. Write an efficient 
 * code to find the missing integer.
 * 
 * Example: 
 * Input: arr[] = {1, 2, 4, 6, 3, 7, 8}
 * Output: 5
 * Input: arr[] = {1, 2, 3, 5}
 * Output: 4
 */
public class CodeProblem1 {
    static int findDisappearedNumbers1(int[] arr, int n) {
        int sum = ((n + 1) * (n + 2)) / 2;
        for (int i = 0; i < n; i++) {
            sum -= arr[i];
        }
        return sum;
    }

    static int findDisappearedNumbers2(int[] arr, int n) {
        int total = 1;
        for (int i = 2; i <= n + 1; i++) {
            total += i;
            total -= arr[i - 2];
        }
        return total;
    }

    /** Find missing Number using xor */
    static int findDisappearedNumbers3(int[] arr, int n) {
        int x1 = arr[0];
        int x2 = 1;

        for (int i = 1; i < n; i++) {
            x1 = x1 ^ arr[i];
        }

        for (int i = 2; i <= n + 1; i++) {
            x2 = x2 ^ i;
        }

        return x1 ^ x2;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        int n = arr.length;

        System.out.println(findDisappearedNumbers1(arr, n));
        System.out.println(findDisappearedNumbers2(arr, n));
        System.out.println(findDisappearedNumbers3(arr, n));
    }
}
