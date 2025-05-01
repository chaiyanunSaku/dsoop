/*
Name: Chaiyanun Sakulsaowapakkul
ID: 6681299
 */

package A1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Happy {
    public static void main(String[] args) {
        System.out.println(7%10);
        System.out.println(sumOfDigitsSquared(7));
        System.out.println(isHappy(100));
        System.out.println(isHappy(111));
        System.out.println(isHappy(989));
        System.out.println(Arrays.toString(firstK(10)));
    }

    public static long sumOfDigitsSquared(long n) {
        long sum = 0;
        while (n > 0) {  // keep going till n < 0
            long digit = n % 10;    // mod 10 to use the last digit
            sum += digit * digit;   // square and add to sum
            n = n/10;               // removing the last digit
        }
        return sum;
    }

    public static boolean isHappy(long n) {
        while (n != 1 && n != 4) {      // while n is not equal to 1 and 4
            n = sumOfDigitsSquared(n);  // keep looping it
        }
        return n == 1;    // it's either 1 or 4 now then return n == 1 to check true or false
    }

    public static long[] firstK(int k) {
        long[] answer = new long[k];
        int count = 0;
        long current = 1;

        while (count < k) {
            if (isHappy(current)) {  // check if isHappy == true if so answer[count] = current, count++
                answer[count] = current;
                count++;
            }
            current++;     // when finish one big loop then increment to the next current
        }
        return answer;
    }
}