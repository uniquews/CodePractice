package fb;

import utils.TreeNode;

public class ShorestDistBetweenTwoNodes {
    private int d1 = -1;
    private int d2 = -1;
    private int result;

    //每次调用function都会初始化variable
    public int shorestDistBetweenTwoNodes(TreeNode root, TreeNode m, TreeNode n) {
        d1 = -1;
        d2 = -1;
        result = 0;

        findLCA(root, m, n, 0);

        if (d1 != -1 && d2 != -1) {
            return result;
        }

        // m, n is ancestor-child
        if (d1 == -1) {
            findDist(n, m, 0);
            return result;
        }

        findDist(m, n, 0);
        return result;
    }

    private void findDist(TreeNode s, TreeNode t, int level) {
        if (s == null) {
            return;
        }

        if (s.equals(t)) {
            result = level;
            return;
        }

        findDist(s.left, t, level + 1);
        findDist(s.right, t, level + 1);
    }

    private TreeNode findLCA(TreeNode root, TreeNode m, TreeNode n, int depth) {
        if (root == null) {
            return null;
        }

        if (root.equals(m)) {
            d1 = depth;
            return root;
        }

        if (root.equals(n)) {
            d2 = depth;
            return root;
        }

        TreeNode leftLCA = findLCA(root.left, m, n, depth + 1);
        TreeNode rightLCA = findLCA(root.right, m, n, depth + 1);

        if (leftLCA != null && rightLCA != null) {
            result = d1 + d2 - depth * 2;
            return root;
        }

        return leftLCA != null ? leftLCA : rightLCA;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(8);
        TreeNode h = new TreeNode(9);
        TreeNode i = new TreeNode(10);

        TreeNode j = new TreeNode(11);

        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;

        c.right = f;

        d.left = g;
        d.right = h;

        e.right = i;
        g.left = j;
        ShorestDistBetweenTwoNodes test = new ShorestDistBetweenTwoNodes();
        System.out.println(test.shorestDistBetweenTwoNodes(a, j, f));

    }
}
