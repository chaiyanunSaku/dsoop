package A7;

import java.util.*;

public class MultiwayMerge {

    static class Pair implements Comparable<Pair> {
        int value;
        int listIndex;

        public Pair(int value, int listIndex) {
            this.value = value;
            this.listIndex = listIndex;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.value, other.value);
        }
    }

    public static LinkedList<Integer> mergeAll(LinkedList<Integer>[] lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int k = lists.length;

        int[] indices = new int[k];

        for (int i = 0; i < k; i++) {
            if (!lists[i].isEmpty()) {
                pq.add(new Pair(lists[i].removeFirst(), i));
            }
        }

        LinkedList<Integer> result = new LinkedList<>();

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            result.add(current.value);

            if (!lists[current.listIndex].isEmpty()) {
                pq.add(new Pair(lists[current.listIndex].removeFirst(), current.listIndex));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LinkedList<Integer>[] lists = new LinkedList[2];
        lists[0] = new LinkedList<>(List.of(1, 3, 5));
        lists[1] = new LinkedList<>(List.of(2, 4));

        LinkedList<Integer> result = MultiwayMerge.mergeAll(lists);
        System.out.println(result);

    }
}
