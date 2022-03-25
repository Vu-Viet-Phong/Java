package maths;

public class AbsoluteValue {
    /**
     * If value is less than zero make value positive.
     * 
     * @param value value a number
     * @return the absolute value of a number
     */
    public static int absVal(int value) {
        return value < 0 ? -value : value;
    }

    public static void main(String[] args) {
        System.out.println(absVal(-10));    // --> 10
        System.out.println(absVal(0));      // --> 0
        System.out.println(absVal(10));     // --> 10
    }
}

