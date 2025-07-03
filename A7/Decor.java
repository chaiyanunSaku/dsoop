package A7;

import java.util.*;

public class Decor {

    public static BinaryTreeNode mkTree(List<Integer> postOrder, List<Integer> inOrder) {
        Map<Integer, Integer> inIndexMap = new HashMap<>();
        for (int i = 0; i < inOrder.size(); i++) {
            inIndexMap.put(inOrder.get(i), i);
        }

        return build(postOrder, inIndexMap, 0, inOrder.size() - 1, new int[]{postOrder.size() - 1});
    }

    private static BinaryTreeNode build(List<Integer> post, Map<Integer, Integer> inMap,
                                        int inLeft, int inRight, int[] postIndex) {
        if (inLeft > inRight) return null;

        int rootVal = post.get(postIndex[0]);
        postIndex[0]--;

        int inIdx = inMap.get(rootVal);

        BinaryTreeNode right = build(post, inMap, inIdx + 1, inRight, postIndex);
        BinaryTreeNode left = build(post, inMap, inLeft, inIdx - 1, postIndex);

        return new BinaryTreeNode(left, rootVal, right);
    }

    public static void main(String[] args) {
        List<Integer> post = List.of(4,5, 2, 6, 7, 3, 1);
        List<Integer> in = List.of(4, 2, 5, 1, 6, 3, 7);

        BinaryTreeNode root = Decor.mkTree(post, in);
        printInOrder(root);
        System.out.println();
        printPostOrder(root);
    }

    private static void printInOrder(BinaryTreeNode node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.key + " ");
        printInOrder(node.right);
    }

    private static void printPostOrder(BinaryTreeNode node) {
        if (node == null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.key + " ");
    }

}
