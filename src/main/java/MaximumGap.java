/**
 * Created by shuaiwang on 1/4/17.
 */

import java.util.ArrayList;

/**
 * Bucket Sort
 * Suppose there are N elements and they range from A to B.

 Then the maximum gap will be no smaller than ceiling[(B - A) / (N - 1)]

 Let the length of a bucket to be len = ceiling[(B - A) / (N - 1)], then we will have at most num = (B - A) / len + 1 of bucket

 for any number K in the array, we can easily find out which bucket it belongs by calculating loc = (K - A) / len and therefore maintain the maximum and minimum elements in each bucket.

 Since the maximum difference between elements in the same buckets will be at most len - 1, so the final answer will not be taken from two elements in the same buckets.

 For each non-empty buckets p, find the next non-empty buckets q, then q.min - p.max could be the potential answer to the question. Return the maximum of all those values.
 *
 * */

public class MaximumGap {
    public int maximumGap(int[] nums) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int maxNum = nums[0];
        int minNum = nums[0];

        for (int i = 0; i < nums.length; i++) {
            maxNum = Math.max(maxNum, nums[i]);
            minNum = Math.min(minNum, nums[i]);
        }

        int lenOfBucket = (int) Math.ceil((maxNum - minNum) * 1.0 / (nums.length - 1));

        if (lenOfBucket == 0) {
            return 0;
        }

        int numOfBucket = (maxNum - minNum) / lenOfBucket + 1; // numOfBucket could be nums.length or nums.length + 1

        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>(numOfBucket);

        for (int i = 0; i < numOfBucket; i++) {
            ArrayList subArr = new ArrayList();
            bucket.add(subArr);
        }

        for (int i = 0; i < nums.length; i++) {
            int bucketNumber = (nums[i] - minNum) / lenOfBucket;
            if (bucket.get(bucketNumber).isEmpty()) {
                bucket.get(bucketNumber).add(0, nums[i]);
                bucket.get(bucketNumber).add(1, nums[i]);
            } else {
                if (nums[i] < bucket.get(bucketNumber).get(0)) {
                    bucket.get(bucketNumber).set(0, nums[i]);
                }

                if (nums[i] > bucket.get(bucketNumber).get(1)) {
                    bucket.get(bucketNumber).set(1, nums[i]);
                }
            }
        }

        int start = 0;
        while (bucket.get(start).isEmpty()) {
            start++;
        }

        int gap = 0;
        for (int i = 1; i < bucket.size(); i++) {
            if (bucket.get(i).isEmpty()) {
                continue;
            }
            gap = Math.max(gap, bucket.get(i).get(0) - bucket.get(start).get(1));
            start = i;
        }
        return gap;
    }
 
    /**
     * @param nums: an array of integers
     * @return: the maximum difference
     */
    public int maximumGapII(int[] nums) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int max = nums[0], min = nums[0];
        for (int n : nums) {
            max = Math.max(n, max);
            min = Math.min(n, min);
        }
        if (max == min) {
            return 0;
        }
        int gap = (int) Math.ceil((max - min) * 1.0 / (nums.length - 1));
        int[][] buckets = new int[(max - min) / gap + 1][2];
        for (int[] bucket : buckets) {
            bucket[0] = -1;
            bucket[1] = -1;
        }
        for (int n : nums) {
            int i = (n - min) / gap;
            if (buckets[i][0] == -1) {
                buckets[i][0] = n;
                buckets[i][1] = n;
            } else {
                buckets[i][0] = Math.min(buckets[i][0], n);
                buckets[i][1] = Math.max(buckets[i][1], n);
            }
        }
        int res = 0;
        for (int i = 0; i < buckets.length - 1; i++) {
            int j = i + 1;
            while (j < buckets.length && buckets[j][0] == -1) {
                j++;
            }
            res = Math.max(res, buckets[j][0] - buckets[i][1]);
            i = j - 1;
        }
        return res;
    }
 
    public static void main(String[] args) {
        MaximumGap test = new MaximumGap();
        int[] A = {2147483647,0};
        System.out.print(test.maximumGap(A));
    }
}
