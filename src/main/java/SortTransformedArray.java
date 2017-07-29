import java.util.Arrays;

/**
 * Created by shuaiwang on 2/1/17.
 */
public class SortTransformedArray {
    // naive O(nlogn) way
//    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
//        int[] result = new int[nums.length];
//
//        for (int i = 0; i < nums.length; i++) {
//            result[i] = a * (nums[i]) * nums[i] + b * nums[i] + c;
//        }
//        Arrays.sort(result);
//        return result;
//    }

    // O(n)
//    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
//        int[] result = new int[nums.length];
//
//        if (a == 0) {
//            if (b > 0) {
//                for (int i = 0; i < nums.length; i++) {
//                    result[i] = nums[i] * b + c;
//                }
//            } else {
//                for (int i = 0; i < nums.length; i++) {
//                    result[i] = nums[nums.length - 1 - i] * b + c;
//                }
//            }
//            return result;
//        }
//        double minX = 1.0 * (-1) * b / (2 * a);
//
//        // find lower/upper bound
//        int upperIndex = 0;
//        int lowerIndex = 0;
//        while (nums[lowerIndex] < minX) {
//            lowerIndex++;
//        }
//
//        if (nums[lowerIndex] > minX) {
//            lowerIndex--;
//        }
//        upperIndex = lowerIndex + 1;
//
//        int i = 0;
//        while (lowerIndex >= 0 || upperIndex <= nums.length - 1) {
//            if (lowerIndex < 0) {
//                if (a > 0) {
//                    result[i] = helper(nums[upperIndex], a, b, c);
//                } else {
//                    result[nums.length - 1 - i] = helper(nums[upperIndex], a, b, c);
//                }
//                upperIndex++;
//            } else if (upperIndex == nums.length) {
//                if (a > 0) {
//                    result[i] = helper(nums[lowerIndex], a, b, c);
//                } else {
//                    result[nums.length - 1 - i] = helper(nums[lowerIndex], a, b, c);
//                }
//                lowerIndex--;
//            } else {
//                if (a > 0) {
//                    if (Math.abs(1.0 * nums[lowerIndex] - minX) < Math.abs(1.0 * nums[upperIndex] - minX)) {
//                        result[i] = helper(nums[lowerIndex], a, b, c);
//                        lowerIndex--;
//                    } else {
//                        result[i] = helper(nums[upperIndex], a, b, c);
//                        upperIndex++;
//                    }
//                } else if (a < 0) {
//                    if (Math.abs(1.0 * nums[lowerIndex] - minX) < Math.abs(1.0 * nums[upperIndex] - minX)) {
//                        result[nums.length - 1 - i] = helper(nums[lowerIndex], a, b, c);
//                        lowerIndex--;
//                    } else {
//                        result[nums.length - 1 - i] = helper(nums[upperIndex], a, b, c);
//                        upperIndex++;
//                    }
//                }
//            }
//            i++;
//        }
//        return result;
//    }

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] result = new int[nums.length];
        int index = a == 0 ? (b > 0 ? 0 : nums.length - 1) : helper(nums, 1.0 * (-1) * b / (2 * a));

        if (a >= 0) {
            int left = index - 1, right = index + 1, i = 0;
            result[i++] = getValue(nums[index], a, b, c);
            while (left >= 0 || right < nums.length) {
                int tmp1 = left >= 0 ? getValue(nums[left], a, b, c) : Integer.MAX_VALUE;
                int tmp2 = right < nums.length ? getValue(nums[right], a, b, c) : Integer.MAX_VALUE;
                result[i++] = tmp1 < tmp2 ? tmp1 : tmp2;
                if (tmp1 < tmp2)
                    left--;
                else
                    right++;
            }
        } else {
            int left = index - 1, right = index + 1, i = nums.length - 1;
            result[i--] = getValue(nums[index], a, b, c);

            while (left >= 0 || right < nums.length) {
                int tmp1 = left >= 0 ? getValue(nums[left], a, b, c) : Integer.MIN_VALUE;
                int tmp2 = right < nums.length ? getValue(nums[right], a, b, c) : Integer.MIN_VALUE;
                result[i--] = tmp1 > tmp2 ? tmp1 : tmp2;
                if (tmp1 > tmp2)
                    left--;
                else
                    right++;
            }
        }
        return result;
    }

    private int getValue(int base, int a, int b, int c) {
        return a * base * base + b * base + c;
    }

    private int helper(int[] nums, double target) {
        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (target < nums[start]) {
            return start;
        } else if (target > nums[end]) {
            return end;
        } else if (Math.abs(target - nums[start]) < Math.abs(target - nums[end])) {
            return start;
        } else {
            return end;
        }
    }

    private int helper(int n, int a, int b, int c) {
        return a * n * n + b * n + c;
    }



    public static void main(String[] args) {
        SortTransformedArray test = new SortTransformedArray();
//        int[] array = {-98,-97,-96,-93,-90,-89,-89,-88,-85,-83,-83,-79,-78,-78,-76,-74,-63,-63,-63,-62,-59,-59,-57,-55,-54,-53,-49,-45,-41,-37,-35,-31,-25,-22,-20,-20,-17,-16,-16,-15,-13,-12,-12,-11,-4,-1,0,5,6,7,8,9,13,16,16,29,29,29,31,31,32,32,33,33,34,35,36,39,41,42,43,45,47,49,53,56,59,59,65,66,68,68,70,75,78,80,80,81,82,84,85,85,89,90,90,92,99,99};
//        int[] array = {-98,-97,-96,-93,-90,-89,-89};
        int[] array = {-100,-98,-96,-90,-90,-86,-85,-77,-71,-70,-68,-59,-53,-47,-46,-45,-45,-37,-32,-17,-16,-14,-12,-12,-9,-5,-5,-4,-3,-1,1,7,10,18,19,21,24,28,29,29,32,42,46,46,54,55,59,62,64,68,76,80,96,98};
        System.out.print(test.sortTransformedArray(array, 74,77,64));
    }
}
