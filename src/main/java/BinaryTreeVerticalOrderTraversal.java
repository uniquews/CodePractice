import utils.TreeNode;

import java.util.*;

/**
 * Created by shuaiwang on 5/7/17.
 */
public class BinaryTreeVerticalOrderTraversal {
    class Node {
        public int offset;
        public TreeNode n;

        public Node(int o, TreeNode node) {
            offset = o;
            n = node;
        }
    }


    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        int minLevel = Integer.MAX_VALUE;
        int maxLevel = Integer.MIN_VALUE;

        Queue<Node> q = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        q.add(new Node(0, root));

        while (!q.isEmpty()) {
            int size = q.size();

            while (size != 0) {
                Node current = q.poll();
                List<Integer> sameLevel = map.getOrDefault(current.offset, new ArrayList<>());
                sameLevel.add(current.n.val);
                map.put(current.offset, sameLevel);
                minLevel = Math.min(minLevel, current.offset);
                maxLevel = Math.max(maxLevel, current.offset);

                if (current.n.left != null) {
                    q.add(new Node(current.offset - 1, current.n.left));
                }
                if (current.n.right != null) {
                    q.add(new Node(current.offset + 1, current.n.right));
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
