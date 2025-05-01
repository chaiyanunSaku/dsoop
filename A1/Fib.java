/*
Name: Chaiyanun Sakulsaowapakkul
ID: 6681299
 */


package A1;

import java.math.BigInteger;

public class Fib {
    public static void main(String[] args) {
        System.out.println(firstNDigit(1));
        System.out.println(firstNDigit(2));
        System.out.println(firstNDigit(3));
        System.out.println(firstNDigit(10));
    }

    public static int firstNDigit(int n ) {
        BigInteger num1 = BigInteger.ONE;
        BigInteger num2 = BigInteger.ONE;

        if (n == 1) {
            return 1;   // first position will always have one digit
        }

        for (int index = 3; index <= 40_000; index++) {
            BigInteger numNext = num1.add(num2);  // create "next" number which add num 1 and 2 together
            num1 = num2;
            num2 = numNext;

            if (numNext.toString().length() >= n) {   // convert numNext to string and check for length
                return index;
            }
        }
        return 0;
    }
}
