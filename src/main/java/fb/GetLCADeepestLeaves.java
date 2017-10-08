package fb;

import utils.TreeNode;

public class GetLCADeepestLeaves {
    class ReturnType {
        TreeNode lca;
        int h;
        public ReturnType(TreeNode lca, int h) {
            this.lca = lca;
            this.h = h;
        }
    }
    public TreeNode getLCADeepestLeaves(TreeNode root) {
        return helper(root).lca;
    }

    private ReturnType helper(TreeNode n) {
        if (n == null) {
            return new ReturnType(null, 0);
        }

        if (n.left == null && n.right == null) {
            return new ReturnType(null, 1);
        }

        ReturnType leftNode = helper(n.left);
        ReturnType rightNode = helper(n.right);

        if ((leftNode.h == 1 && rightNode.h == 0) || (leftNode.h == 0 && rightNode.h == 1)) {
            return new ReturnType(n, 2);
        }

        if (leftNode.h == rightNode.h) {
            return new ReturnType(n, leftNode.h + 1);
        } else if (leftNode.h > rightNode.h) {
            return new ReturnType(leftNode.lca, leftNode.h + 1);
        } else {
            return new ReturnType(rightNode.lca, rightNode.h + 1);
        }
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
        GetLCADeepestLeaves test = new GetLCADeepestLeaves();
        System.out.println(test.getLCADeepestLeaves(a).val);

    }
}
