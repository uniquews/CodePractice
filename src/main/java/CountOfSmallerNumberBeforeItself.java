import utils.TreeNode;

import java.util.ArrayList;

/**
 * Created by shuaiwang on 1/7/17.
 */
public class CountOfSmallerNumberBeforeItself {
    class TreeNode {
        public int val;
        public int count;
        public boolean isLeft;

        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
            count = 1;
        }

        public void increaseCount() {
            count++;
        }
    }

    class Tree {
        public TreeNode root;

        public Tree(int num) {
            root = new TreeNode(num);
        }

        public TreeNode add(int num) {
            return addToRoot(root, num);
        }

        private TreeNode addToRoot(TreeNode node, int num) {
            node.count++;

            if (node.val < num) {
                if (node.right == null) {
                    TreeNode current = new TreeNode(num);
                    node.right = current;
                    current.isLeft = false;
                    return current;
                } else {
                    addToRoot(node, num);
                }
            } else if (node.val > num) {
                if (node.left == null) {
                    TreeNode current = new TreeNode(num);
                    node.left = current;
                    current.isLeft = true;
                    return current;
                } else {
                    addToRoot(node, num);
                }
            } else {
                return node;
            }
            return new TreeNode(-1);
        }
    }
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here

        ArrayList<Integer> result = new ArrayList<>();

        if (A == null || A.length == 0) {
            return result;
        }

        Tree tree = new Tree(A[0]);

        for (int i = 1; i < A.length; i++) {
            TreeNode current = tree.add(A[i]);
            if (current.isLeft) {
                if (current.left != null) {
                    result.add(current.left.count);
                } else {
                    result.add(0);
                }
            } else {
                if (current.right != null) {
                    result.add(tree.root.count - (current.right.count + current.count));
                } else {
                    result.add(tree.root.count - current.count);
                }
            }
        }
        return result;
    }
}
