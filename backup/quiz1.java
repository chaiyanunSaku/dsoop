package week3;

import java.util.Arrays;

public class quiz1 {
    public static void main(String[] args) {
        int[] a = new int[3];
        a[0] = 1;
        a[1] = 3;
        System.out.println(Arrays.toString(a));

        int[] x = new int[]{1,3,5};
        int[] y = {1,3,5,4};
        System.out.println(Arrays.toString(y));
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(len(new String[]{"h", "el", "l", "o,W", "orld!"})));
    }

    public static int[] len(String[] arr) {
        int [] lengths = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            lengths[i] = arr[i].length();
        }
        return lengths;
    }
}
