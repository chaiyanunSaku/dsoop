package week6;

public class Main {
    public static void main(String[] args) {
        BoundedSkipper skipper = new BoundedSkipper(3, 11);
        BoundedSkipper skipper2 = new BoundedSkipper(4, 20);

        for (int num : skipper) {
            System.out.println(num);
        }

        for (int num : skipper2) {
            System.out.println(num + " new");
        }
    }
}