import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shuaiwang on 4/29/17.
 */
public class FindModeInBinarySearchTree {
    // 弱鸡做法：
//    private HashMap<Integer, Integer> hashMap = new HashMap<>();
//    private int maxOccur = 0;
//    private int size = 0;
//    public int[] findMode(TreeNode root) {
//        helper(root);
//        List<Integer> list = new ArrayList<>();
//        for (Integer node : hashMap.keySet()) {
//            if (hashMap.get(node) == maxOccur) {
//                list.add(node);
//            }
//        }
//
//        int[] result = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            result[i] = list.get(i);
//        }
//        return result;
//    }
//
//    private void helper(TreeNode n) {
//        if (n == null) {
//            return;
//        }
//        size++;
//        int val = n.val;
//        if (hashMap.containsKey(val)) {
//            hashMap.put(val, hashMap.get(val) + 1);
//            maxOccur = Math.max(maxOccur, hashMap.get(val));
//        } else {
//            maxOccur = Math.max(maxOccur, 1);
//            hashMap.put(val, 1);
//        }
//        helper(n.left);
//        helper(n.right);
//    }




    // O(1) space
    private int maxOccur = 0;
    private int size = 0;
    private int count = 0;
    private int lastElement = 0; // 不知道初始化 int 该是什么
    private int index = 0;
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        inorder(root);
        lastElement = 0;
        count = 0;
        int[] result = new int[size];
        inorder2(root, result);
        return result;
    }

    private void inorder(TreeNode n) {
        if (n == null) {
            return;
        }
        inorder(n.left);

        int val = n.val;
        if (val == lastElement) {
            count++;
        } else {
            count = 1;
        }

        if (count > maxOccur) {
            size = 1;
            maxOccur = count;
        } else if (count == maxOccur) {
            size++;
        }

        lastElement = val;
        inorder(n.right);
    }

    private void inorder2(TreeNode n, int[] result) {
        if (n == null) {
            return;
        }

        inorder2(n.left, result);
        int val = n.val;
        if (val == lastElement) {
            count++;
        } else {
            count = 1;
        }
        if (count == maxOccur) {
            result[index++] = val;
        }
        lastElement = val;
        inorder2(n.right, result);
    }

    public static void main(String[] arges) {
        TreeNode n = new TreeNode(1);
        TreeNode a = new TreeNode(2);
//        TreeNode b = new TreeNode(2);
        n.right = a;
//        a.left = b;

        FindModeInBinarySearchTree test = new FindModeInBinarySearchTree();
        test.findMode(n);
    }
}
