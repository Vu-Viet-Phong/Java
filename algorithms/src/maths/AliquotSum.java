package maths;

/**
 * In number theory, the aliquot sum s(n) of a positive 
 * integer n is the sum of all proper divisors of n, that
 * is, all divisors of n other than n itself. It can be 
 * used to characterize the prime numbers, perfect numbers, 
 * deficient numbers, abundant numbers, and untouchable 
 * numbers, and to define the aliquot sequence of a number.
 * For example, the proper divisors of 15 (that is, the 
 * positive divisors of 15 that are not equal to 15) are 1,
 * 3 and 5, so the aliquot sum of 15 is 9 i.e. (1 + 3 + 5).
 * 
 * @link https://en.wikipedia.org/wiki/Aliquot_sum
 */
public class AliquotSum {
    /**
     * Finds the aliquot sum of an integer number
     * 
     * @param number a positive integer
     * @return aliquot sum of given {@code number}
     */
    public static int aliquotSum(int number) {
        int sum = 1; // 1 is a proper divisor

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                sum += i;
                
                // To handle perfect squares
                if (number / i != i)
                    sum += number / i;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(aliquotSum(220));    // --> 284
        System.out.println(aliquotSum(1184));   // --> 1210
        System.out.println(aliquotSum(2620));   // --> 2924
        System.out.println(aliquotSum(5020));   // --> 5564
    }
}
