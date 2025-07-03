package A7;

import java.util.*;

public class Uproot {

    public static HashMap<Integer, Integer> treeToParentMap(BinaryTreeNode T) {
        HashMap<Integer, Integer> map = new HashMap<>();
        dfs(T, null, map);
        return map;
    }

    private static void dfs(BinaryTreeNode node, Integer parentKey, HashMap<Integer, Integer> map) {
        if (node == null) return;

        if (parentKey != null) {
            map.put(node.key, parentKey);
        }

        dfs(node.left, node.key, map);
        dfs(node.right, node.key, map);
    }

    public static BinaryTreeNode parentMapToTree(Map<Integer, Integer> map) {
        HashMap<Integer, BinaryTreeNode> nodes = new HashMap<>();
        for (Integer childKey : map.keySet()) {
            nodes.putIfAbsent(childKey, new BinaryTreeNode(childKey));
            Integer parentKey = map.get(childKey);
            nodes.putIfAbsent(parentKey, new BinaryTreeNode(parentKey));
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int childKey = entry.getKey();
            int parentKey = entry.getValue();
            BinaryTreeNode parent = nodes.get(parentKey);
            BinaryTreeNode child = nodes.get(childKey);

            if (parent.left == null) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }

        Set<Integer> children = map.keySet();
        Set<Integer> allNodes = new HashSet<>(children);
        allNodes.addAll(map.values());

        for (Integer key : allNodes) {
            if (!children.contains(key)) {
                return nodes.get(key);
            }
        }

        return null; // in case something went wrong
    }

    public static void main(String[] args) {
        BinaryTreeNode T = new BinaryTreeNode(
                new BinaryTreeNode(2),
                1,
                new BinaryTreeNode(
                        new BinaryTreeNode(14),
                        20,
                        new BinaryTreeNode(9)
                )
        );

        HashMap<Integer, Integer> map = treeToParentMap(T);
        System.out.println("Parent Map: " + map);

        BinaryTreeNode rebuilt = parentMapToTree(map);
        System.out.print("Rebuilt tree (in-order): ");
        printInOrder(rebuilt);
    }

    private static void printInOrder(BinaryTreeNode node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.key + " ");
        printInOrder(node.right);
    }

}

