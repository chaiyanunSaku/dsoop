package week2;

public class L4 {
    public static void main(String[] args) {
        SLList L = new SLList();
        L.addLast(41);
        L.addLast(9);
        L.addLast(10);
        L.addLast(23);
        //L.first.next = L.first; <-- not allow anymore after setting int first to be private
        System.out.println(L.toString());
        L.removeFirst();
        System.out.println(L.toString());
        System.out.println(L.size());
    }
}
