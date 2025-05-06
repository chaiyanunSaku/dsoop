package week2;

public class L3 {
    public static void main(String[] args) {
        IntNode list = null;
        list = new IntNode(4, list);
        list = new IntNode(1, list);
        list = new IntNode(3, list);
        list = new IntNode(2, list);
        System.out.println(list.iterativeToString());
        System.out.println(list.get(2));
        list.set(2,9);
        System.out.println(list.iterativeToString());
        System.out.println(list.get(2));
        System.out.println(list.iterativeToString());
        System.out.println(list.incrlist(100));

//        IntNode list = new IntNode(3, );
//        list.head = 3;
//        list.next = new IntNode();
//        list.next.head = 1;
//        list.next.next = new IntNode();
//        list.next.next.head = 4;
//        list.next.next.next = null;
    }
}
