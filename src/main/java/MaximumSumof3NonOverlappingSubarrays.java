public class MaximumSumof3NonOverlappingSubarrays {
//    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
//        if (nums == null || nums.length == 0) {
//            return new int[0];
//        }
//        int[] left = new int[nums.length];
//        int[] right = new int[nums.length];
//        int[] lp = new int[nums.length];
//        int[] rp = new int[nums.length];
//
//        int sum = 0;
//        for (int i = 0; i < k; i++) {
//            sum += nums[i];
//        }
//        left[k - 1] = sum;
//        lp[k - 1] = k - 1;
//        int maxVal = sum;
//        for (int i = k; i < nums.length; i++) {
//            sum += nums[i];
//            sum -= nums[i - k];
//            if (sum <= maxVal) {
//                left[i] = maxVal;
//                lp[i] = lp[i - 1];
//            } else {
//                left[i] = sum;
//                lp[i] = i;
//            }
//            maxVal = Math.max(maxVal, left[i]);
//        }
//
//        sum = 0;
//        for (int i = nums.length - 1; i >= nums.length - k; i--) {
//            sum += nums[i];
//        }
//        right[nums.length - k] = sum;
//        rp[nums.length - k] = nums.length - k;
//        maxVal = sum;
//        for (int i = nums.length - k - 1; i >= 0; i--) {
//            sum += nums[i];
//            sum -= nums[i + k];
//            if (sum <= maxVal) {
//                right[i] = maxVal;
//                rp[i] = rp[i + 1];
//            } else {
//                right[i] = sum;
//                rp[i] = i;
//
//            }
//            maxVal = Math.max(maxVal, right[i]);
//        }
//
//        sum = 0;
//        for (int i = k; i < k * 2; i++) {
//            sum += nums[i];
//        }
//        maxVal = sum + left[k - 1] + right[k * 2];
//        int[] result = new int[3];
//        result[0] = 0;
//        result[1] = k;
//        result[2] = rp[2 * k];
//
//
//        for (int i = 2 * k; i < nums.length - k; i++) {
//            sum += nums[i];
//            sum -= nums[i - k];
//            if (sum + right[i + 1] + left[i - k] > maxVal) {
//                result[0] = lp[i - k] - k  + 1;
//                result[1] = i - k + 1;
//                result[2] = rp[i + 1];
//                maxVal = sum + right[i + 1] + left[i - k];
//            }
//        }
//        return result;
//    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        int[] left = new int[nums.length + 1];
        int[] right = new int[nums.length + 1];
        int[] lp = new int[nums.length + 1];
        int[] rp = new int[nums.length + 1];

        int maxVal = Integer.MIN_VALUE;
        for (int i = k; i <= nums.length - k; i++) {
            int tmp = sum[i] - sum[i - k];
            if (tmp > maxVal) {
                left[i] = tmp;
                lp[i] = i;
            } else {
                left[i] = maxVal;
                lp[i] = lp[i - 1];
            }
            maxVal = Math.max(left[i], maxVal);
        }

        maxVal = Integer.MIN_VALUE;
        for (int i = nums.length - k + 1; i > k; i--) {
            int tmp = sum[i + k - 1] - sum[i - 1];
            if (tmp >= maxVal) {
                right[i] = tmp;
                rp[i] = i;
            } else {
                right[i] = maxVal;
                rp[i] = rp[i + 1];
            }
            maxVal = Math.max(maxVal, right[i]);
        }

        int[] result = new int[3];
        maxVal = Integer.MIN_VALUE;
        for (int i = k + 1; i <= nums.length - 2 * k + 1; i++) {
            int tmp = sum[i + k - 1] - sum[i - 1];
            if (tmp + left[i - 1] + right[i + k] > maxVal) {
                result[0] = lp[i - 1] - k;
                result[1] = i - 1;
                result[2] = rp[i + k] - 1;
                maxVal = tmp + left[i - 1] + right[i + k];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {17,8,14,11,13,9,4,19,20,6,1,20,6,5,19,8,5,16,20,17};
        int k = 5;
        MaximumSumof3NonOverlappingSubarrays test = new MaximumSumof3NonOverlappingSubarrays();
        test.maxSumOfThreeSubarrays(a, k);
    }
}
