package main;

import main.utils.TreeNode;

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
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], new TreeNode(A[i]));
        }

        int[] leftBiggerNum = getFirstBiggerNumberOnLeft(A);
        int[] rightBiggerNum = getFirstBiggerNumberOnRight(A);

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

    private int[] getFirstBiggerNumberOnRight(int[] A) {
        Stack<Integer> stk = new Stack<>();
        int[] rightBiggerNum = new int[A.length];
        Arrays.fill(rightBiggerNum, -1);

        for (int i = 0; i <= A.length; i++) {
            int cur = i == A.length ? Integer.MAX_VALUE : A[i];
            while (!stk.isEmpty() && cur > A[stk.peek()]) {
                if (cur == Integer.MAX_VALUE) {
                    break;
                } else {
                    int child = stk.pop();
                    rightBiggerNum[child] = i;
                }
            }
            stk.push(i);
        }
        return rightBiggerNum;
    }

    private int[] getFirstBiggerNumberOnLeft(int[] A) {
        Stack<Integer> stk = new Stack<>();
        int[] leftBiggerNum = new int[A.length];
        Arrays.fill(leftBiggerNum, -1);

        for (int i = A.length - 1; i >= -1; i--) {
            int cur = i == -1 ? Integer.MAX_VALUE : A[i];
            while (!stk.isEmpty() && cur > A[stk.peek()]) {
                if (cur == Integer.MAX_VALUE) {
                    break;
                } else {
                    int child = stk.pop();
                    leftBiggerNum[child] = i;
                }
            }
            stk.push(i);
        }
        return leftBiggerNum;
    }

    public static void main(String[] args) {
        MaxTree test = new MaxTree();
        int[] A = {2,5,6,0,3,1};
        test.maxTree(A);
    }

}
