import utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by shuaiwang on 11/3/16.
 */
public class MaxTree {
    public TreeNode maxTree(int[] A) {
        // write your code here

        HashMap<Integer, TreeNode> map = new HashMap<>();
        for (int num : A) {
            map.put(num, new TreeNode(num));
        }

        int[][] biggerNum = helper(A);
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

    private int[][] helper(int[] A) {
        Stack<Integer> stk = new Stack<>();

        int[][] result = new int[2][A.length];
        int[] leftFirstBigger = new int[A.length];
        int[] rightFirstBigger = new int[A.length];

        for (int i = 0; i <= A.length; i++) {
            int h = i == A.length ? Integer.MAX_VALUE : A[i];
            while (!stk.isEmpty() && h > A[stk.peek()]) {
                int current = stk.pop();
                if (i == A.length) {
                    rightFirstBigger[current] = -1;
                } else {
                    rightFirstBigger[current] = i;
                }
                if (stk.isEmpty()) {
                    leftFirstBigger[current] = -1;
                } else {
                    leftFirstBigger[current] = stk.peek();
                }
            }
            stk.push(i);
        }

        result[0] = leftFirstBigger;
        result[1] = rightFirstBigger;
        return result;
    }

    public static void main(String[] args) {
        MaxTree test = new MaxTree();
        int[] A = {2, 5, 6, 0, 3, 1};
        test.maxTree(A);
    }

}
