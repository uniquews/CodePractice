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
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] result = new int[nums.length];

        if (a == 0) {
            if (b > 0) {
                for (int i = 0; i < nums.length; i++) {
                    result[i] = nums[i] * b + c;
                }
            } else {
                for (int i = 0; i < nums.length; i++) {
                    result[i] = nums[nums.length - 1 - i] * b + c;
                }
            }
            return result;
        }
        double minX = 1.0 * (-1) * b / (2 * a);

        // find upper bound
        int upperIndex = 0;
        int lowerIndex = 0;
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (1.0 * nums[mid] == minX) {
                upperIndex = mid;
                lowerIndex = mid;
                break;
            } else if (1.0 * nums[mid] > minX) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (start + 1 >= end) {
            if (1.0 * nums[start] == minX) {
                upperIndex = start;
                lowerIndex = start;
            } else if (1.0 * nums[end] == minX) {
                upperIndex = end;
                lowerIndex = end;
            } else {
                lowerIndex = start;
                upperIndex = end;
            }
        }

        int i = 0;
        while (lowerIndex >= 0 || upperIndex <= nums.length - 1) {
            if (lowerIndex < 0) {
                if (a > 0) {
                    result[i] = helper(nums[upperIndex], a, b, c);
                } else {
                    result[nums.length - 1 - i] = helper(nums[upperIndex], a, b, c);
                }
                upperIndex++;
            } else if (upperIndex == nums.length) {
                if (a > 0) {
                    result[i] = helper(nums[lowerIndex], a, b, c);
                } else {
                    result[nums.length - 1 - i] = helper(nums[lowerIndex], a, b, c);
                }
                lowerIndex--;
            } else {
                if (a > 0) {
                    if (Math.abs(1.0 * nums[lowerIndex] - minX) < Math.abs(1.0 * nums[upperIndex] - minX)) {
                        result[i] = helper(nums[lowerIndex], a, b, c);
                        lowerIndex--;
                    } else {
                        result[i] = helper(nums[upperIndex], a, b, c);
                        if (lowerIndex == upperIndex)
                            lowerIndex--;
                        upperIndex++;
                    }
                } else if (a < 0) {
                    if (Math.abs(1.0 * nums[lowerIndex] - minX) < Math.abs(1.0 * nums[upperIndex] - minX)) {
                        result[nums.length - 1 - i] = helper(nums[lowerIndex], a, b, c);
                        lowerIndex--;
                    } else {
                        result[nums.length - 1 - i] = helper(nums[upperIndex], a, b, c);
                        if (lowerIndex == upperIndex)
                            lowerIndex--;
                        upperIndex++;
                    }
                }
            }
            i++;
        }
        return result;
    }

    private int helper(int n, int a, int b, int c) {
        return a * n * n + b * n + c;
    }



    public static void main(String[] args) {
        SortTransformedArray test = new SortTransformedArray();
        int[] array = {-98,-97,-96,-93,-90,-89,-89,-88,-85,-83,-83,-79,-78,-78,-76,-74,-63,-63,-63,-62,-59,-59,-57,-55,-54,-53,-49,-45,-41,-37,-35,-31,-25,-22,-20,-20,-17,-16,-16,-15,-13,-12,-12,-11,-4,-1,0,5,6,7,8,9,13,16,16,29,29,29,31,31,32,32,33,33,34,35,36,39,41,42,43,45,47,49,53,56,59,59,65,66,68,68,70,75,78,80,80,81,82,84,85,85,89,90,90,92,99,99};
//        int[] array = {-98,-97,-96,-93,-90,-89,-89};
        System.out.print(test.sortTransformedArray(array, -8,-16,69));
    }
}
