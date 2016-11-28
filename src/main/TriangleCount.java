package main;

import java.util.Arrays;

/**
 * Created by shuaiwang on 11/23/16.
 */
public class TriangleCount {
    public int triangleCount(int S[]) {
        // write your code here
        Arrays.sort(S);
        int result = 0;
        for (int i = S.length - 1; i >= 2; i--) {
            result += helper(S, S[i], i - 1);
        }
        return result;
    }

    private int helper(int[] S, int target, int end) {
        int start = 0;
        int result = 0;
        while (start < end) {

            if (S[start] + S[end] > target) {
                result += end - start;
                end--;
            } else {
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {4,4,4,4};
        TriangleCount test = new TriangleCount();
        System.out.print(test.triangleCount(A));
    }
}
