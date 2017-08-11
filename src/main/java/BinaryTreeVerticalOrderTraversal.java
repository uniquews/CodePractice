import utils.TreeNode;

import java.util.*;

/**
 * Created by shuaiwang on 5/7/17.
 */
public class BinaryTreeVerticalOrderTraversal {
    class Node {
        private TreeNode n;
        private int index;

        public Node(TreeNode t, int l) {
            n = t;
            index = l;
        }
    }
//    public List<List<Integer>> verticalOrder(TreeNode root) {
//        if (root == null) {
//            return new ArrayList<>();
//        }
//        Map<Integer, List<Integer>> level = new TreeMap<>();
//        Queue<Node> queue = new LinkedList<>();
//
//        queue.add(new Node(root, 0));
//        while (!queue.isEmpty()) {
//            Queue<Node> nextQueue = new LinkedList<>();
//            while (!queue.isEmpty()) {
//                Node cur = queue.poll();
//                if (!level.containsKey(cur.index)) {
//                    level.put(cur.index, new ArrayList<>(Arrays.asList(cur.n.val)));
//                } else {
//                    level.get(cur.index).add(cur.n.val);
//                }
//
//                if (cur.n.left != null) {
//                    nextQueue.add(new Node(cur.n.left, cur.index - 1));
//                }
//                if (cur.n.right != null) {
//                    nextQueue.add(new Node(cur.n.right, cur.index + 1));
//                }
//            }
//            queue = nextQueue;
//        }
//
//        List<List<Integer>> result = new ArrayList<>();
//        for (Integer l : level.keySet()) {
//            result.add(level.get(l));
//        }
//
//        return result;
//    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        int minLevel = 0, maxLevel = 0;
        Node n = new Node(root, 0);
        Queue<Node> q = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        q.add(n);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size != 0) {
                Node current = q.poll();
                int level = current.index;
                List<Integer> list = map.getOrDefault(level, new ArrayList<>());
                list.add(current.n.val);
                map.put(level, list);

                if (current.n.left != null) {
                    Node leftNode = new Node(current.n.left, current.index - 1);
                    q.add(leftNode);
                    minLevel = Math.min(minLevel, current.index - 1);
                }

                if (current.n.right != null) {
                    Node rightNode = new Node(current.n.right, current.index + 1);
                    q.add(rightNode);
                    maxLevel = Math.max(maxLevel, current.index + 1);
                }

                size--;
            }
        }

        for (int i = minLevel; i <= maxLevel; i++) {
            result.add(map.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        BinaryTreeVerticalOrderTraversal test = new BinaryTreeVerticalOrderTraversal();
        test.verticalOrder(a);
    }

}
