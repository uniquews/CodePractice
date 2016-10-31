package main;

/**
 * Created by shuaiwang on 10/30/16.
 *
 * Given an integer array, heapify it into a min-heap array.

 For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].

 */
public class Heapify {

    // Solution 1 Build a heap bottom up
    public void heapify(int[] A) {
        // write your code here

        for (int i = A.length / 2; i >= 0; i--) {
            helper(A, i);
        }

    }

    private void helper(int[] A, int index) {
        while (index < A.length) {
            int smallest = index;
            if (index * 2 + 1 < A.length && A[index * 2 + 1] < A[index]) {
                smallest = index * 2 + 1;
            }

            if (index * 2 + 2 < A.length && A[index * 2 + 2] < A[smallest]) {
                smallest = index * 2 + 2;
            }

            if (smallest == index) {
                return;
            }

            int tmp = A[index];
            A[index] = A[smallest];
            A[smallest] = tmp;

            index = smallest;
        }
    }
}
