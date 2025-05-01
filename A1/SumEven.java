/*
Name: Chaiyanun Sakulsaowapakkul
ID: 6681299
 */

package A1;

public class SumEven {
    public static void main(String[] args) {
        System.out.println(sumEven(5    ));
        //System.out.println(sumEvenTask3(5    ));

    }

    // The loop will take "n" steps
    public static long sumEven(int n) {
        long ans = 0;                                        // 2*(0-1) = -2
        for (int i = 1; i <= n; i++) {    // i = 1 else it's gonna hit negative on the first iteration
            ans += 2*(i-1);      // 2*(1-1) = 0, 2*(2-1) = 2, 2*(3-1) = 4.
        }                        // ans keep adding for 'n' times
        return ans;
    }

    public static long sumEvenTask3(int nn) {   // subtask 3 using new formula
        long answer = nn*(nn-1);
        return answer;              // one step
    }
}
