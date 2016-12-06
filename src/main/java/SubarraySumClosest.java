/**
 * Created by shuaiwang on 10/3/16.
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by shuaiwang on 10/2/16.
 */

public class SubarraySumClosest {
    class Pair {
        int sum;
        int index;

        public Pair(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }

    public int[] subarraySumClosest(int[] nums) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            return result;
        }

        Pair[] sums = new Pair[nums.length + 1];
        Pair dummy = new Pair(0, 0);
        sums[0] = dummy;

        int prev = 0;
        for (int i = 1; i <= nums.length; i++) {
            Pair newPair = new Pair(prev + nums[i - 1], i);
            sums[i] = newPair;
            prev = newPair.sum;
        }

        Arrays.sort(sums, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.sum - o2.sum;
            }
        });

        int gap = Integer.MAX_VALUE;
        for (int i = 1; i < sums.length; i++) {
            if (gap > sums[i].sum - sums[i - 1].sum) {
                gap = sums[i].sum - sums[i - 1].sum;
                int[] tmp = new int[2];
                tmp[0] = sums[i - 1].index - 1;
                tmp[1] = sums[i].index - 1;
                Arrays.sort(tmp);
                result[0] = tmp[0] + 1;
                result[1] = tmp[1];
            }
        }
        return result;
    }
}

