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
    static int findDisappearedNumbers(int[] arr) {
        int n = arr.length;
        int sum = ((n + 1) * (n + 2)) / 2;

        for (int i = 0; i < n; i++) {
            sum -= arr[i];
        }
        return sum;
    }
}
