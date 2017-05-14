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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, List<Integer>> level = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(root, 0));
        while (!queue.isEmpty()) {
            Queue<Node> nextQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                if (!level.containsKey(cur.index)) {
                    level.put(cur.index, new ArrayList<>(Arrays.asList(cur.n.val)));
                } else {
                    level.get(cur.index).add(cur.n.val);
                }

                if (cur.n.left != null) {
                    nextQueue.add(new Node(cur.n.left, cur.index - 1));
                }
                if (cur.n.right != null) {
                    nextQueue.add(new Node(cur.n.right, cur.index + 1));
                }
            }
            queue = nextQueue;
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Integer l : level.keySet()) {
            result.add(level.get(l));
        }

        return result;
    }


}
