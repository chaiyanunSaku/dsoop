/*
Name: Chaiyanun Sakulsaowapakkul
ID: 6681299
 */

package A1;

import java.util.Arrays;

public class Subsel {
    public static void main(String[] args) {
        int[] a = {2,7,1,8,4,5};
        System.out.println(Arrays.toString(takeEvery(new int[]{1, 2, 3, 4}, 2)));
        System.out.println(Arrays.toString(takeEvery(new int[]{2, 7, 1, 8, 4, 5}, 3, 2)));
        System.out.println(Arrays.toString(takeEvery(new int[]{3, 1, 4, 5, 9, 2, 6, 5}, -1, 5)));
        System.out.println(Arrays.toString(takeEvery(a, 3, 2)));
    }

    public static int[] takeEvery(int[] a, int stride, int beginWith) {
        if (stride == 0) {    // if stride == 0 then it wont move
            throw new IllegalArgumentException("stride must be greater than 0");
        }

        int count = 0;
        if (stride > 0) {  // positive stride
            for (int index = beginWith; index < a.length; index += stride) {
                count++;
            }
        } else {           // negative stride
            for (int index = beginWith; index >= 0; index += stride) {
                count++;
            }
        }

        // create an array with correct size
        int[] ans = new int[count];

        int position = 0;
        if (stride >= 0) {
            for (int index = beginWith; index < a.length; index += stride) {
                ans[position] = a[index];    // ans[position] will become a[index]
                position++;
            }
        } else {
            for (int index = beginWith; index >= 0; index += stride) {
                ans[position] = a[index];
                position++;
            }
        }
        return ans;
    }

    public static int[] takeEvery(int[] a, int stride) {
        return takeEvery(a, stride, 0);
    }

    /*
    create count with the same loop condition with the main loops
    to see how many iteration could it run

    create a new array with correct size to return it in the end

    start looping: set ans[position] to a[index]
     */

}
