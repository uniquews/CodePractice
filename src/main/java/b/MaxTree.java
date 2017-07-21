package b;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by bohan on 7/16/17.
 */
public class MaxTree {
    public TreeNode maxTree(int[] A) {
        // write your code here

        HashMap<Integer, TreeNode> map = new HashMap<>();
        for (int num : A) {
            map.put(num, new TreeNode(num));
        }

        int[][] biggerNum = getBiggerNumberOnBothSides(A);
        int[] leftBiggerNum = biggerNum[0];
        int[] rightBiggerNum = biggerNum[1];

        TreeNode root = new TreeNode(-1);
        for (int i = 0; i < A.length; i++) {
            if (leftBiggerNum[i] == -1 && rightBiggerNum[i] == -1) {
                root = map.get(A[i]);
            } else if (leftBiggerNum[i] == -1) {
                map.get(A[rightBiggerNum[i]]).left = map.get(A[i]);
            } else if (rightBiggerNum[i] == -1) {
                map.get(A[leftBiggerNum[i]]).right = map.get(A[i]);
            } else {
                if (A[leftBiggerNum[i]] < A[rightBiggerNum[i]]) {
                    map.get(A[leftBiggerNum[i]]).right = map.get(A[i]);
                } else {
                    map.get(A[rightBiggerNum[i]]).left = map.get(A[i]);
                }
            }
        }
        return root;
    }

    private int[][] getBiggerNumberOnBothSides(int[] A) {
        int[][] res = new int[2][A.length];
        int[] leftBigger = new int[A.length];
        int[] rightBigger = new int[A.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= A.length; i++) {
            int h = i == A.length ? Integer.MAX_VALUE : A[i];
            while (!stack.isEmpty() && h >= A[stack.peek()]) {
                int index = stack.pop();
                leftBigger[index] = stack.isEmpty() ? -1 : stack.peek();
                rightBigger[index] = i == A.length ? -1 : i;
            }
            stack.push(i);
        }
        res[0] = leftBigger;
        res[1] = rightBigger;
        return res;
    }
}
