package A7;

import java.util.*;

public class MakeTree {

    /*
    The algorithm first sorts the input array in O(n log n) time. Then it recursively
    constructs a balanced binary search tree in O(n) time by always choosing the middle
    element as the root, ensuring the two subtrees are of approximately equal size.
    so the overall time complexity is O(n log n).
     */

    public static void main(String[] args) {
        int[] keys = {7, 2, 9, 1, 5};
        BinaryTreeNode root = buildBST(keys);

        System.out.print("In-order traversal of BST: ");
        printInOrder(root);
    }

    public static BinaryTreeNode buildBST(int[] keys) {
        Arrays.sort(keys);  // O(n long n)
        return buildBalanced(keys, 0, keys.length - 1);
    }

    private static BinaryTreeNode buildBalanced(int[] sortedKeys, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        BinaryTreeNode left = buildBalanced(sortedKeys, start, mid - 1);
        BinaryTreeNode right = buildBalanced(sortedKeys, mid + 1, end);
        return new BinaryTreeNode(left, sortedKeys[mid], right);
    }

    private static void printInOrder(BinaryTreeNode node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.key + " ");
        printInOrder(node.right);
    }
}
