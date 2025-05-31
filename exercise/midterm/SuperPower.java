package peak;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class SuperPower {
    public static int numSPUpTo(int n) {
        int count = 0;
        for (int i = 1; i <= n ; i++) {
            if (isSuperPower(helpPower(i))) {
                count++;
            }
        }
        return count;
    }

    public static int kthSP(int k) {
        int count = 0;
        int i = 1;
        while (true) {
            if (isSuperPower(helpPower(i))) {
                count++;
                if (count == k) return i;
            }
            i++;
        }
    }

    public static BigInteger helpPower(int n) {
        BigInteger base = BigInteger.valueOf(n);
        return base.pow(7);  // n^7
    }

    public static boolean isSuperPower(BigInteger bigNum) {
        String s = bigNum.toString();
        Set<Character> digits = new HashSet<>();

        for (char c : s.toCharArray()) {
            digits.add(c);
            if (digits.size() == 10) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(helpPower(56));
        System.out.println(numSPUpTo(500));
        System.out.println(kthSP(5));
    }
}
