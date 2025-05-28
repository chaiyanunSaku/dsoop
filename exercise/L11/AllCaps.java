package week6;

import java.util.ArrayList;
import java.util.Arrays;

public class AllCaps {
    public static int[] allCapLocations(String st) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < st.length(); i++) {
            if (Character.isUpperCase(st.charAt(i))){
                ans.add(i);
            }
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(allCapLocations("mN@@@@1oO")));
        System.out.println(Arrays.toString(allCapLocations("")));
    }
}
