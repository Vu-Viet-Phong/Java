package maths;

/**
 * Amicable numbers are two different numbers related in such a way that the 
 * sum of the proper divisors of each is equal to the other number.
 * Example : (220, 284) 
 * => 220 is divisible by {1,2,4,5,10,11,20,22,44,55,110 } => Sum = 284
 * @link https://en.wikipedia.org/wiki/Amicable_numbers
 */
public class AmicableNumbers {
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

    /**
     * Check if pair is amicable
     * 
     * @param number1 a positive integer
     * @param number2 a positive integer
     * @return {@code true} if given number is Amicable Number, {@code false} otherwise
     */
    static boolean isAmicableNumber(int number1, int number2) {
        return (aliquotSum(number1) == number2 && aliquotSum(number2) == number1);  
    }

    /**
     * Find all amicable numbers in range
     * 
     * @param start starting position
     * @param stop stopping position
     */
    public static void findInRange1(int start, int stop) {
        int count = 0;

        for (int i = start + 220; i < stop; i++) {
            for (int j = i + 1; j <= stop; j++) {
                if (isAmicableNumber(i, j)) {
                    count++;
                    System.out.println("(" + i + ", " + j + ")");
                }
            }
        }
        System.out.println("In the range from " + start + " to " 
                                                + stop  + " there are " 
                                                + count + " Amicable Number");
    }

    /**
     * While these rules do generate some pairs of amicable numbers, many other pairs 
     * are known, so these rules are by no means comprehensive. In particular, the 
     * rules below produce only even amicable pairs, so they are of no interest for 
     * the open problem of finding amicable pairs coprime to 210 = 2·3·5·7, while 
     * over 1000 pairs coprime to 30 = 2·3·5 are known [García, Pedersen & te Riele
     * (2003), Sándor & Crstici (2004)].
     * 
     * The Thābit ibn Qurra theorem is a method for discovering amicable numbers 
     * invented in the ninth century by the Arab mathematician Thābit ibn Qurra
     * 
     * @param start starting position
     * @param stop stopping position
     */
    public static void findInRange2(int start, int stop) {
        int i, j, k;
        
        k = 2;
        while (true) {
            i = (int) (Math.pow(2, k) * (3 * Math.pow(2, (k - 1)) - 1) * (3 * Math.pow(2, k) - 1));
            j = (int) (Math.pow(2, k) * (9 * Math.pow(2, (2 * k - 1)) - 1)); 
            
            if (i < stop || j < stop) {
                System.out.println("(" + i + ", " + j + ")");
                k++;
            } else {
                break;
            }
        }
        System.out.println("In the range from " +  start  + " to " 
                                                +  stop   + " there are " 
                                                + (k - 2) + " Amicable Number");
    }

    public static void main(String[] args) {
        System.out.println(isAmicableNumber(220, 284));     // true
        System.out.println(isAmicableNumber(1184, 1210));   // true
        System.out.println(isAmicableNumber(2620, 2924));   // true
        System.out.println(isAmicableNumber(5020, 5564));   // true

        System.out.println(isAmicableNumber(112, 223));     // false
        System.out.println(isAmicableNumber(1000, 2100));   // false
        
        System.out.println();
        findInRange1(0, 30000);
        
        System.out.println();
        findInRange2(0, 30000);
    }
}
