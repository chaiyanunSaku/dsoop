package afetquiz1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

interface Series {
    int next();
    void reset();
}

class Odds implements Series {
    private int cur = 1;
    @Override
    public int next() {
        cur += 2;
        return cur -2;
    }

    @Override
    public void reset() {
        cur = 1;
    }
}
class PowTwo implements Series {
    private int cur = 2;
    @Override
    public int next() {
        cur *= 2;
        return cur / 2;
    }

    @Override
    public void reset() {
        cur = 2;
    }

    public int magic(int x) {
        return x + 41;
    }
}

public class L6 {
//    static int sumList(ArrayList<Integer> list) {
//        int sum = 0;
//        for (int ele: list) {
//            sum += ele;
//        }
//        return sum;
//    }
//
//    static int sumList(LinkedList<Integer> list) {
//        int sum = 0;
//        for (int ele: list) {
//            sum += ele;
//        }
//        return sum;
//    }

    static int sumList(List<Integer> list) {
        int sum = 0;
        for (int ele: list) {
            sum += ele;
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        List<Integer> listToo = new LinkedList<>();
 //        Odds odds = new Odds();
//        PowTwo powTwo = new PowTwo();
//        System.out.println(odds.next());
//        System.out.println(powTwo.next());
//        System.out.println(powTwo.magic(2));
//        Series s1 = odds;
//        Series s2 = powTwo;
//        s1.reset();
//        // s2.magic(12);   // not possible
//        Series[] awesome = {s1, s2};
    }
}
