package maths;

/**
 * In number theory, a narcissistic number[1][2] (also known as a pluperfect 
 * digital invariant (PPDI),[3] an Armstrong number[4] (after Michael 
 * F.Armstrong)[5] or a plus perfect number)[6] in a given number base 
 * b is a number that is the sum of its own digits each raised to the power 
 * of the number of digits.
 * Example : 3*3*3 + 7*7*7 + 0*0*0 = 370
 * 
 * @link https://en.wikipedia.org/wiki/Narcissistic_number
 */
public class ArmstrongNumber {
    /**
     * Checks whether a given number is an armstrong number or not.
     * 
     * @param number  number to check
     * @return {@code true} if given number is armstrong number, {@code false} otherwise
     */
    public static boolean isArmStrongNumber(int number) {
        int sum = 0;
        int temp = number;
        int numberOfDigits = 0;
        
        while (temp > 0) {
            numberOfDigits++;
            temp /= 10;
        }

        temp = number;
        
        while (number > 0) {
            int remainder = number % 10;
            int power = 1;

            for (int i = 1; i <= numberOfDigits; power *= remainder, i++);
            sum += power;
            number /= 10; 
        }

        return sum == temp;
    }

    public static void main(String[] args) {
        System.out.println(isArmStrongNumber(0));       // true
        System.out.println(isArmStrongNumber(1));       // true
        System.out.println(isArmStrongNumber(2));       // true
        System.out.println(isArmStrongNumber(10));      // false
        System.out.println(isArmStrongNumber(153));     // true
        System.out.println(isArmStrongNumber(200));     // false
        System.out.println(isArmStrongNumber(371));     // true
        
    }
}
