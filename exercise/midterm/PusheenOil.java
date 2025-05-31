package peak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class PusheenOil {
    private int[] mewlist;

    public PusheenOil(int[] mewlist) {
        this.mewlist = new int[mewlist.length];
        System.arraycopy(mewlist, 0, this.mewlist, 0, mewlist.length);
    }

    public PusheenOil(List<Integer> formula, int n) {
        this.mewlist = new int[n+1];
        if (formula.isEmpty()) {
            mewlist[0] = -1;
            return;
        }
        mewlist[0] = formula.get(0);
        for (int i = 0; i < formula.size() - 1;i++) {
            int current = formula.get(i);
            int next = formula.get(i + 1);
            mewlist[current] = next;
        }
        mewlist[formula.get(formula.size() - 1)] = -1;
    }

    public List<Integer> asList() {
        List<Integer> result = new ArrayList<>();
        int curr = mewlist[0];
        while (curr != -1) {
            result.add(curr);
            curr = mewlist[curr];
        }
        return result;
    }

    public int[] asMewList() {
        return Arrays.copyOf(mewlist, mewlist.length);
    }

    public void reverse() {
        int prev = -1;
        int curr = mewlist[0];
        while (curr != -1) {
            int next = mewlist[curr];
            mewlist[curr] = prev;
            prev = curr;
            curr = next;
        }
        mewlist[0] = prev;
    }

    public void pop() {
        if (mewlist[0] == -1) {
            throw new NoSuchElementException("Cannot pop from an empty sequence");
        }

        int curr = mewlist[0];
        int prev = -1;

        while (mewlist[curr] != -1) {
            prev = curr;
            curr = mewlist[curr];
        }

        if (prev == -1) {
            // Only one element in the list
            mewlist[0] = -1;
        } else {
            mewlist[prev] = -1;
        }
    }
    public static void main(String[] args) {
        // Example 1: Build from normal sequence
        List<Integer> formula = Arrays.asList(3, 1, 2, 4);
        int n = 7; // max value in the sequence (1..n)

        PusheenOil oil = new PusheenOil(formula, n);

        System.out.println("Original asList: " + oil.asList());      // [3, 1, 2, 4]
        System.out.println("Original mewList: " + Arrays.toString(oil.asMewList()));

        // Reverse it
        oil.reverse();
        System.out.println("After reverse asList: " + oil.asList()); // [4, 2, 1, 3]

        // Pop last
        oil.pop();
        System.out.println("After pop asList: " + oil.asList());     // [4, 2, 1]

        // Show final mewlist
        System.out.println("Final mewList: " + Arrays.toString(oil.asMewList()));
    }
}
