import utils.TreeNode;

import java.util.*;

/**
 * Created by shuaiwang on 5/6/17.
 */
public class BoundaryOfBinaryTree {
//    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
//        if (root == null) {
//            return new ArrayList<>();
//        }
//        if (root.left == null && root.right == null)
//            return new ArrayList<>(Arrays.asList(root.val));
//
//        List<Integer> result = new ArrayList<>();
//        result.add(root.val);
//
//        List<Integer> allLeaves = new ArrayList<>();
//        findAllLeaves(root, allLeaves);
//
//        List<Integer> leftBound = new ArrayList<>();
//        findLeftBoundary(root.left, leftBound);
//
//        List<Integer> rightBound = new ArrayList<>();
//        findRightBoundary(root.right, rightBound);
//
//        result.addAll(leftBound);
//        result.addAll(allLeaves);
//        result.addAll(rightBound);
//        return result;
//    }
//
//    private void findAllLeaves(TreeNode n, List<Integer> allLeaves) {
//        if (n == null) {
//            return;
//        }
//
//        if (n.left == null && n.right == null) {
//            allLeaves.add(n.val);
//        }
//
//        findAllLeaves(n.left, allLeaves);
//        findAllLeaves(n.right, allLeaves);
//    }
//
//    private void findLeftBoundary(TreeNode n, List<Integer> leftBound) {
//        if (n == null) {
//            return;
//        }
//
//        if (n.left == null && n.right == null) {
//            return;
//        }
//
//        leftBound.add(n.val);
//        if (n.left != null) {
//            findLeftBoundary(n.left, leftBound);
//        } else {
//            findLeftBoundary(n.right, leftBound);
//        }
//    }
//
//    private void findRightBoundary(TreeNode n, List<Integer> rightBound) {
//        if (n == null) {
//            return;
//        }
//
//        if (n.left == null && n.right == null) {
//            return;
//        }
//
//        rightBound.add(0, n.val);
//        if (n.right != null) {
//            findRightBoundary(n.right, rightBound);
//        } else {
//            findRightBoundary(n.left, rightBound);
//        }
//    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> leftBound = new LinkedList<>();
        List<Integer> leafBound = new LinkedList<>();
        List<Integer> rightBound = new LinkedList<>();
        List<Integer> result = new LinkedList<>();

        if (root == null)
            return result;

        if (root.left == null && root.right == null) {
            result.add(root.val);
            return result;

        }


        leftBound.add(root.val);
        getLeftBound(root.left, leftBound);
        getLeafBound(root, leafBound);
        getRightBound(root.right, rightBound);

        result.addAll(leftBound);
        result.addAll(leafBound);
        result.addAll(rightBound);
        return result;
    }

    private void getLeftBound(TreeNode n, List<Integer> leftBound) {
        if (n == null)
            return;

        if (n.left == null && n.right == null)
            return;

        leftBound.add(n.val);
        if (n.left != null) {
            getLeftBound(n.left, leftBound);
        } else {
            getLeftBound(n.right, leftBound);
        }
    }

    private void getLeafBound(TreeNode n, List<Integer> leafBound) {
        if (n == null)
            return;
        if (n.left == null && n.right == null) {
            leafBound.add(n.val);
            return;
        }
        getLeafBound(n.left, leafBound);
        getLeafBound(n.right, leafBound);
    }

    private void getRightBound(TreeNode n, List<Integer> rightBound) {
        if (n == null) {
            return;
        }

        if (n.left == null && n.right == null)
            return;

        rightBound.add(0, n.val);
        if (n.right != null) {
            getRightBound(n.right, rightBound);
        } else {
            getRightBound(n.left, rightBound);
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        b.left = c;
        b.right = d;
        a.right = b;

        BoundaryOfBinaryTree test = new BoundaryOfBinaryTree();
        test.boundaryOfBinaryTree(a);
    }
}
